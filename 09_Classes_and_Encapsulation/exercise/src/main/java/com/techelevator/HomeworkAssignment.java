package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }
    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }
    public int getPossibleMarks() {
        return possibleMarks;
    }
    public String getSubmitterName() {
        return submitterName;
    }
    public String getLetterGrade() {

        double percentage = (double) earnedMarks / possibleMarks;
        String letterGrade;
        if (percentage >= 0.9) {
            letterGrade = "A";
        }
        else if (percentage >=0.8) {
            letterGrade = "B";
        }
        else if (percentage >= 0.7) {
            letterGrade = "C";
        }
        else if (percentage >= 0.6) {
            letterGrade = "D";
        }
        else {
            letterGrade = "F";
        }

        return letterGrade;
    }




}
