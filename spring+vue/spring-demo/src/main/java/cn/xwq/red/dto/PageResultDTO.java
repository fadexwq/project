package cn.xwq.red.dto;

import java.util.List;

/**
 * 分页结果承载
 */
public class PageResultDTO {
    private long total;
    private List<?> rows;

    public PageResultDTO() {
    }

    public PageResultDTO(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
