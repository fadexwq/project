package cn.ego.base.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

@TableName("tb_content")
public class Content {

  @TableId(value = "id",type = IdType.AUTO)
  private long id;

  @TableField(value = "category_id")
  private long categoryId;

  private String title;

  @TableField(value = "sub_title")
  private String subTitle;

  @TableField(value = "title_desc")
  private String titleDesc;
  private String url;
  private String pic;
  private String pic2;
  private String content;
  private Date created;
  private Date updated;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }


  public String getTitleDesc() {
    return titleDesc;
  }

  public void setTitleDesc(String titleDesc) {
    this.titleDesc = titleDesc;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }


  public String getPic2() {
    return pic2;
  }

  public void setPic2(String pic2) {
    this.pic2 = pic2;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }


  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

}
