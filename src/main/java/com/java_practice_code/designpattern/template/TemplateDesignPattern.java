package com.java_practice_code.designpattern.template;

/**
 * author: lujingxiao
 * description:
 * 老师会发给每个同学一份事先出好的试卷，这样在题目上所有同学拿到的都是同一份试卷，
 * 学生只负责写上自己的答案，我们也就有了同样的标准来评判每个人的成绩水平。
 * 我们将试卷抽象成公共类，每个学生的试卷继承这个试卷公共类，只在自己类里实现“答案”即可。可见其实模板方法模式的类结构很简单。
 * date: Created in 2019/9/7.
 */
public class TemplateDesignPattern {
    public static void main(String[] args) {
        AbstractClass a = new ConcreteClassA();
        showStudentAnswer(a);

        AbstractClass b = new ConcreteClassB();
        showStudentAnswer(b);
    }

    private static void showStudentAnswer(AbstractClass student) {
        student.templateMethod1();
        student.templateMethod2();
    }
}
