package com.oopsdev.ex.generic;

import java.util.Arrays;

public class WildCardEx {
    public static void registerCourse(Course<?> course) {
        System.out.println(course.getName() + "수강생: " + Arrays.toString(course.getStudents()));
    }
    
    //extends는 상위타입 제한
    public static void registerCourseStudent(Course<? extends Student> course) {
        System.out.println(course.getName() + "수강생: " + Arrays.toString(course.getStudents()));
    }
    
    //super는 하위타입 제한
    public static void registerCourseWorker(Course<? super Worker> course) {
        System.out.println(course.getName() + "수강생: " + Arrays.toString(course.getStudents()));
    }

    public static void main(String[] args) {
        Course<Person> personCourse = new Course<>("일반인 과정", 5);
        personCourse.add(new Person("일반인"));
        personCourse.add(new Person("직장인"));
        personCourse.add(new Person("학생"));
        personCourse.add(new Person("고등학생"));

        Course<Worker> workerCourse = new Course<>("직장인 과정", 5);
        workerCourse.add(new Worker("직장인"));

        Course<Student> studentCourse = new Course<>("학생 과정", 5);
        studentCourse.add(new Student("학생"));
        studentCourse.add(new HighStudent("고등학생"));

        Course<HighStudent> highStudentCourse = new Course<>("학생 과정", 5);
        highStudentCourse.add(new HighStudent("고등학생"));

        registerCourse(personCourse);
        registerCourse(workerCourse);
        registerCourse(studentCourse);
        registerCourse(highStudentCourse);
        System.out.println();

//        registerCourseStudent(personCourse);
//        registerCourseStudent(workerCourse);
        registerCourseStudent(studentCourse);
        registerCourseStudent(highStudentCourse);
        System.out.println();

        registerCourseWorker(personCourse);
        registerCourseWorker(workerCourse);
//        registerCourseWorker(studentCourse);
//        registerCourseWorker(highStudentCourse);
        System.out.println();

//        registerCourse(new Course<Person>("일반인 과정",5));
//        registerCourse(new Course<Student>("학생 과정",5));
//        registerCourse(new Course<Worker>("근로자 과정",5));
//        registerCourse(new Course<HighStudent>("고등학생 과정",5));
    }
}
