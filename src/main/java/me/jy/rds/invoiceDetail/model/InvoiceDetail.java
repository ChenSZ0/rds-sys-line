package me.jy.rds.invoiceDetail.model;

import me.jy.rds.common.base.BaseForm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class InvoiceDetail extends BaseForm implements Serializable {
    private Long id;

    private String number;

    private Long ticketUser;

    private String ticketName;

    private Long cardUser;

    private String cardName;

    private String cardNum;

    private Date consumeTime;

    private BigDecimal cardMoney;

    private BigDecimal cashMoney;

    private BigDecimal cashSubsidy;

    private Long responsibleUser;

    private String responsibleName;

    private Long invoiceTypeId;

    private String invoiceType;

    private String month;

    private String summary;

    private String refund;

    private Date receivingTime;

    private Date receivedTime;

    private Date accountTime;

    private String purpose;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Long getTicketUser() {
        return ticketUser;
    }

    public void setTicketUser(Long ticketUser) {
        this.ticketUser = ticketUser;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName == null ? null : ticketName.trim();
    }

    public Long getCardUser() {
        return cardUser;
    }

    public void setCardUser(Long cardUser) {
        this.cardUser = cardUser;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    public BigDecimal getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(BigDecimal cardMoney) {
        this.cardMoney = cardMoney;
    }

    public BigDecimal getCashMoney() {
        return cashMoney;
    }

    public void setCashMoney(BigDecimal cashMoney) {
        this.cashMoney = cashMoney;
    }

    public BigDecimal getCashSubsidy() {
        return cashSubsidy;
    }

    public void setCashSubsidy(BigDecimal cashSubsidy) {
        this.cashSubsidy = cashSubsidy;
    }

    public Long getResponsibleUser() {
        return responsibleUser;
    }

    public void setResponsibleUser(Long responsibleUser) {
        this.responsibleUser = responsibleUser;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName == null ? null : responsibleName.trim();
    }

    public Long getInvoiceTypeId() {
        return invoiceTypeId;
    }

    public void setInvoiceTypeId(Long invoiceTypeId) {
        this.invoiceTypeId = invoiceTypeId;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType == null ? null : invoiceType.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getRefund() {
        return refund;
    }

    public void setRefund(String refund) {
        this.refund = refund == null ? null : refund.trim();
    }

    public Date getReceivingTime() {
        return receivingTime;
    }

    public void setReceivingTime(Date receivingTime) {
        this.receivingTime = receivingTime;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        InvoiceDetail other = (InvoiceDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getTicketUser() == null ? other.getTicketUser() == null : this.getTicketUser().equals(other.getTicketUser()))
            && (this.getTicketName() == null ? other.getTicketName() == null : this.getTicketName().equals(other.getTicketName()))
            && (this.getCardUser() == null ? other.getCardUser() == null : this.getCardUser().equals(other.getCardUser()))
            && (this.getCardName() == null ? other.getCardName() == null : this.getCardName().equals(other.getCardName()))
            && (this.getCardNum() == null ? other.getCardNum() == null : this.getCardNum().equals(other.getCardNum()))
            && (this.getConsumeTime() == null ? other.getConsumeTime() == null : this.getConsumeTime().equals(other.getConsumeTime()))
            && (this.getCardMoney() == null ? other.getCardMoney() == null : this.getCardMoney().equals(other.getCardMoney()))
            && (this.getCashMoney() == null ? other.getCashMoney() == null : this.getCashMoney().equals(other.getCashMoney()))
            && (this.getCashSubsidy() == null ? other.getCashSubsidy() == null : this.getCashSubsidy().equals(other.getCashSubsidy()))
            && (this.getResponsibleUser() == null ? other.getResponsibleUser() == null : this.getResponsibleUser().equals(other.getResponsibleUser()))
            && (this.getResponsibleName() == null ? other.getResponsibleName() == null : this.getResponsibleName().equals(other.getResponsibleName()))
            && (this.getInvoiceTypeId() == null ? other.getInvoiceTypeId() == null : this.getInvoiceTypeId().equals(other.getInvoiceTypeId()))
            && (this.getInvoiceType() == null ? other.getInvoiceType() == null : this.getInvoiceType().equals(other.getInvoiceType()))
            && (this.getMonth() == null ? other.getMonth() == null : this.getMonth().equals(other.getMonth()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getRefund() == null ? other.getRefund() == null : this.getRefund().equals(other.getRefund()))
            && (this.getReceivingTime() == null ? other.getReceivingTime() == null : this.getReceivingTime().equals(other.getReceivingTime()))
            && (this.getReceivedTime() == null ? other.getReceivedTime() == null : this.getReceivedTime().equals(other.getReceivedTime()))
            && (this.getAccountTime() == null ? other.getAccountTime() == null : this.getAccountTime().equals(other.getAccountTime()))
            && (this.getPurpose() == null ? other.getPurpose() == null : this.getPurpose().equals(other.getPurpose()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getTicketUser() == null) ? 0 : getTicketUser().hashCode());
        result = prime * result + ((getTicketName() == null) ? 0 : getTicketName().hashCode());
        result = prime * result + ((getCardUser() == null) ? 0 : getCardUser().hashCode());
        result = prime * result + ((getCardName() == null) ? 0 : getCardName().hashCode());
        result = prime * result + ((getCardNum() == null) ? 0 : getCardNum().hashCode());
        result = prime * result + ((getConsumeTime() == null) ? 0 : getConsumeTime().hashCode());
        result = prime * result + ((getCardMoney() == null) ? 0 : getCardMoney().hashCode());
        result = prime * result + ((getCashMoney() == null) ? 0 : getCashMoney().hashCode());
        result = prime * result + ((getCashSubsidy() == null) ? 0 : getCashSubsidy().hashCode());
        result = prime * result + ((getResponsibleUser() == null) ? 0 : getResponsibleUser().hashCode());
        result = prime * result + ((getResponsibleName() == null) ? 0 : getResponsibleName().hashCode());
        result = prime * result + ((getInvoiceTypeId() == null) ? 0 : getInvoiceTypeId().hashCode());
        result = prime * result + ((getInvoiceType() == null) ? 0 : getInvoiceType().hashCode());
        result = prime * result + ((getMonth() == null) ? 0 : getMonth().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getRefund() == null) ? 0 : getRefund().hashCode());
        result = prime * result + ((getReceivingTime() == null) ? 0 : getReceivingTime().hashCode());
        result = prime * result + ((getReceivedTime() == null) ? 0 : getReceivedTime().hashCode());
        result = prime * result + ((getAccountTime() == null) ? 0 : getAccountTime().hashCode());
        result = prime * result + ((getPurpose() == null) ? 0 : getPurpose().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", ticketUser=").append(ticketUser);
        sb.append(", ticketName=").append(ticketName);
        sb.append(", cardUser=").append(cardUser);
        sb.append(", cardName=").append(cardName);
        sb.append(", cardNum=").append(cardNum);
        sb.append(", consumeTime=").append(consumeTime);
        sb.append(", cardMoney=").append(cardMoney);
        sb.append(", cashMoney=").append(cashMoney);
        sb.append(", cashSubsidy=").append(cashSubsidy);
        sb.append(", responsibleUser=").append(responsibleUser);
        sb.append(", responsibleName=").append(responsibleName);
        sb.append(", invoiceTypeId=").append(invoiceTypeId);
        sb.append(", invoiceType=").append(invoiceType);
        sb.append(", month=").append(month);
        sb.append(", summary=").append(summary);
        sb.append(", refund=").append(refund);
        sb.append(", receivingTime=").append(receivingTime);
        sb.append(", receivedTime=").append(receivedTime);
        sb.append(", accountTime=").append(accountTime);
        sb.append(", purpose=").append(purpose);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}