package com.leejs.springbootWeb.board.domain.paging;

import lombok.Getter;

@Getter
public class Criteria {

    private int page;
    private int perPageNum;

    public int getPageStart() {
        return (this.page - 1) * perPageNum;
    }

    public Criteria() {
        this.page = 1;
        this.perPageNum = 10;
    }

    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public void setPerPageNum(int pageCount) {
        int cnt = this.perPageNum;
        if(pageCount != cnt) {
            this.perPageNum = cnt;
        } else {
            this.perPageNum = pageCount;
        }
    }
}
