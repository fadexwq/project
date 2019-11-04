package cn.ego.base.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

@TableName("tb_item_param")
public class ItemParam {

  @TableId(value = "id",type = IdType.AUTO)
  private long id;

  @TableField(value = "item_cat_id")
  private long itemCatId;

  @TableField(value = "param_data")
  private String paramData;
  private Date created;
  private Date updated;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getItemCatId() {
    return itemCatId;
  }

  public void setItemCatId(long itemCatId) {
    this.itemCatId = itemCatId;
  }

  public String getParamData() {
    return paramData;
  }

  public void setParamData(String paramData) {
    this.paramData = paramData;
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
