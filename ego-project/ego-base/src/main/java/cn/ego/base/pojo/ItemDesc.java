package cn.ego.base.pojo;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

@TableName("tb_item_desc")
public class ItemDesc {

  @TableId(value = "item_id",type = IdType.INPUT)
  private long itemId;

  @TableField(value = "item_desc")
  private String itemDesc;

  private Date created;

  private Date updated;


  public long getItemId() {
    return itemId;
  }

  public void setItemId(long itemId) {
    this.itemId = itemId;
  }


  public String getItemDesc() {
    return itemDesc;
  }

  public void setItemDesc(String itemDesc) {
    this.itemDesc = itemDesc;
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
