package com.lijin.vo;

import java.io.Serializable;

public class SearchVo implements Serializable {
    private String word;
    private String searchType;
    private Integer days;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Word:"+word+" SearchType:"+searchType+" Days:"+days;
    }
}
