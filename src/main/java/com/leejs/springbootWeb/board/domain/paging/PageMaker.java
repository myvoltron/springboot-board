package com.leejs.springbootWeb.board.domain.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageMaker {

    private int page;       // 현재 페이지
    private int perPageNum; // 페이지 당 나타낼 post 개수
    private int totalCount; // 총 post 개수
    private int startPage;  // 현재 화면에 보여질 페이지 그룹의 start number
    private int endPage;    // 현재 화면에 보여질 페이지 그룹의 end number
    private int prevNum;    // 이전 페이지 숫자
    private int nextNum;    // 다음 페이지 숫자
    private boolean prev;   // 이전 페이지 여부
    private boolean next;   // 다음 페이지 여부
    private int displayPageNum = 5; // 하단에 보여지는 페이지 버튼의 수

    public PageMaker() {
        perPageNum = 10;
    }

    public int getPageStart() {
        return (this.page - 1) * perPageNum;
    }

    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }

    private void calcData() { // 총 게시글 수 세팅 후 실행됨
        endPage = (int) (Math.ceil(this.getPage() / (double) displayPageNum) * displayPageNum);

        startPage = (endPage - displayPageNum) + 1;
        if(startPage <= 0) startPage = 1; // 0이하이면 안되니 최소값 1로 설정

        int tempEndPage = (int) (Math.ceil(totalCount / (double) this.getPerPageNum()));
        if (endPage > tempEndPage) { //
            endPage = tempEndPage;
        }

        prevNum = page - 1;
        nextNum = page + 1;

        prev = startPage != 1;
        next = endPage * this.getPerPageNum() < totalCount;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }
}
