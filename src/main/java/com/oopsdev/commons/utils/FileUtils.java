package com.oopsdev.commons.utils;

import com.oopsdev.commons.exception.AttachFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileUtils {

    /*
    @사용법
    1. VO
    - private MultipartFile[] attachFile; private String[] file_cd; gatter/setter 등록

    2. Controller
    - 서비스.insertFile(map,**VO.getAttachFile(),**VO.getFile_cd());

    3. Service
    - void insertFile(HashMap<String, Object> map, MultipartFile[] files, String[] file_cd) throws Exception;

    4. ServiceImpl
    -   @Override
        public void insertFile(HashMap<String, Object> map, MultipartFile[] files, String[] file_cd) throws Exception {
            System.out.println(files.length);
            for(int i=0; i<files.length; i++) {
                List<HashMap<String, Object>> fileList = fileUtils.uploadFiles(files, String.valueOf(i));
                if (!CollectionUtils.isEmpty(fileList) && fileList.get(i).get("file_append_ori") != "") {
                    map.put("ori_file_name", fileList.get(i).get("file_append_ori"));
                    map.put("sav_file_name", fileList.get(i).get("file_append_sav"));
                    map.put("file_cd", file_cd[i]);
                    **Mapper.insertFile(map);
                }
            }
        }
     5. Mapper
     - int insertFile(HashMap<String, Object> map) throws Exception;

     6. XML
	    <insert id="insertFile" parameterType="hashmap">
            INSERT INTO TB_**(
                id,
                ori_file_name,
                sav_file_name,
                file_cd
            ) VALUES(
                #{id},
                #{ori_file_name},
                #{sav_file_name},
                #{file_cd}
            )
        </insert>
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CfgCommon cfgCommon;

    /** 오늘 날짜 */
    private final String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));

    /**
     * 서버에 생성할 파일명을 처리할 랜덤 문자열 반환
     * @return 랜덤 문자열
     */
    private final String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 서버에 첨부 파일을 생성하고, 업로드 파일 목록 반환
     * @param files    - 파일 Array
     * @param boardIdx - 게시글의 파일 순서
     * @return 업로드 파일 목록
     */
    public List<HashMap<String,Object>> uploadFiles(MultipartFile[] files, String boardIdx) {

        /* 파일이 비어있으면 비어있는 리스트 반환 */
        if(boardIdx == "") {
            if (files[0].getSize() < 1) {
                return Collections.emptyList();
            }
        } else {
            if(files[Integer.valueOf(boardIdx)].getSize() < 1) {
                return Collections.emptyList();
            }
        }

        /* 업로드 파일 정보를 담을 비어있는 리스트 */
        List<HashMap<String,Object>> attachList = new ArrayList<>();

        /* uploadPath에 해당하는 디렉터리가 존재하지 않으면, 부모 디렉터리를 포함한 모든 디렉터리를 생성 */
        String uploadPath = Paths.get(cfgCommon.getFilePath()).toString();
        logger.info("uploadPath: " + uploadPath);
        File dir = new File(uploadPath);
        if (dir.exists() == false) {
            dir.mkdirs();
        }

        /* 파일 개수만큼 forEach 실행 */
        for (MultipartFile file : files) {
            try {
                /* 파일 확장자 */
                final String extension = FilenameUtils.getExtension(file.getOriginalFilename());
                /* 서버에 저장할 파일명 (랜덤 문자열 + 확장자) */
                final String saveName = getRandomString() + "." + extension;

                /* 업로드 경로에 saveName과 동일한 이름을 가진 파일 생성 */
                File target = new File(uploadPath, saveName);
                file.transferTo(target);

                /* 파일 정보 저장 */
                HashMap<String,Object> attach = new HashMap<String,Object>();
                attach.put("idx", boardIdx);
                attach.put("file_append_ori", file.getOriginalFilename());
                attach.put("file_append_sav", saveName);
                attach.put("filesize", file.getSize());

                /* 파일 정보 추가 */
                attachList.add(attach);

            } catch (IOException e) {
                throw new AttachFileException("[" + file.getOriginalFilename() + "] failed to save file...");

            } catch (Exception e) {
                throw new AttachFileException("[" + file.getOriginalFilename() + "] failed to save file...");
            }
        } // end of for

        return attachList;
    }
}
