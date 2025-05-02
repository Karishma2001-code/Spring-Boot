package org.example;

import java.util.List;

public class Subject {
    @Override
    public String toString() {
        return "Subject{" +
                "subject=" + subject +
                '}';
    }

    public Subject(List<String> subject) {
        this.subject = subject;
    }

    private   List<String> subject;
}
