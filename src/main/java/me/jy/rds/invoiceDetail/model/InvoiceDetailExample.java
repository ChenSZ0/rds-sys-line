package me.jy.rds.invoiceDetail.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvoiceDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andTicketUserIsNull() {
            addCriterion("ticket_user is null");
            return (Criteria) this;
        }

        public Criteria andTicketUserIsNotNull() {
            addCriterion("ticket_user is not null");
            return (Criteria) this;
        }

        public Criteria andTicketUserEqualTo(Long value) {
            addCriterion("ticket_user =", value, "ticketUser");
            return (Criteria) this;
        }

        public Criteria andTicketUserNotEqualTo(Long value) {
            addCriterion("ticket_user <>", value, "ticketUser");
            return (Criteria) this;
        }

        public Criteria andTicketUserGreaterThan(Long value) {
            addCriterion("ticket_user >", value, "ticketUser");
            return (Criteria) this;
        }

        public Criteria andTicketUserGreaterThanOrEqualTo(Long value) {
            addCriterion("ticket_user >=", value, "ticketUser");
            return (Criteria) this;
        }

        public Criteria andTicketUserLessThan(Long value) {
            addCriterion("ticket_user <", value, "ticketUser");
            return (Criteria) this;
        }

        public Criteria andTicketUserLessThanOrEqualTo(Long value) {
            addCriterion("ticket_user <=", value, "ticketUser");
            return (Criteria) this;
        }

        public Criteria andTicketUserIn(List<Long> values) {
            addCriterion("ticket_user in", values, "ticketUser");
            return (Criteria) this;
        }

        public Criteria andTicketUserNotIn(List<Long> values) {
            addCriterion("ticket_user not in", values, "ticketUser");
            return (Criteria) this;
        }

        public Criteria andTicketUserBetween(Long value1, Long value2) {
            addCriterion("ticket_user between", value1, value2, "ticketUser");
            return (Criteria) this;
        }

        public Criteria andTicketUserNotBetween(Long value1, Long value2) {
            addCriterion("ticket_user not between", value1, value2, "ticketUser");
            return (Criteria) this;
        }

        public Criteria andTicketNameIsNull() {
            addCriterion("ticket_name is null");
            return (Criteria) this;
        }

        public Criteria andTicketNameIsNotNull() {
            addCriterion("ticket_name is not null");
            return (Criteria) this;
        }

        public Criteria andTicketNameEqualTo(String value) {
            addCriterion("ticket_name =", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameNotEqualTo(String value) {
            addCriterion("ticket_name <>", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameGreaterThan(String value) {
            addCriterion("ticket_name >", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_name >=", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameLessThan(String value) {
            addCriterion("ticket_name <", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameLessThanOrEqualTo(String value) {
            addCriterion("ticket_name <=", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameLike(String value) {
            addCriterion("ticket_name like", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameNotLike(String value) {
            addCriterion("ticket_name not like", value, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameIn(List<String> values) {
            addCriterion("ticket_name in", values, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameNotIn(List<String> values) {
            addCriterion("ticket_name not in", values, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameBetween(String value1, String value2) {
            addCriterion("ticket_name between", value1, value2, "ticketName");
            return (Criteria) this;
        }

        public Criteria andTicketNameNotBetween(String value1, String value2) {
            addCriterion("ticket_name not between", value1, value2, "ticketName");
            return (Criteria) this;
        }

        public Criteria andCardUserIsNull() {
            addCriterion("card_user is null");
            return (Criteria) this;
        }

        public Criteria andCardUserIsNotNull() {
            addCriterion("card_user is not null");
            return (Criteria) this;
        }

        public Criteria andCardUserEqualTo(Long value) {
            addCriterion("card_user =", value, "cardUser");
            return (Criteria) this;
        }

        public Criteria andCardUserNotEqualTo(Long value) {
            addCriterion("card_user <>", value, "cardUser");
            return (Criteria) this;
        }

        public Criteria andCardUserGreaterThan(Long value) {
            addCriterion("card_user >", value, "cardUser");
            return (Criteria) this;
        }

        public Criteria andCardUserGreaterThanOrEqualTo(Long value) {
            addCriterion("card_user >=", value, "cardUser");
            return (Criteria) this;
        }

        public Criteria andCardUserLessThan(Long value) {
            addCriterion("card_user <", value, "cardUser");
            return (Criteria) this;
        }

        public Criteria andCardUserLessThanOrEqualTo(Long value) {
            addCriterion("card_user <=", value, "cardUser");
            return (Criteria) this;
        }

        public Criteria andCardUserIn(List<Long> values) {
            addCriterion("card_user in", values, "cardUser");
            return (Criteria) this;
        }

        public Criteria andCardUserNotIn(List<Long> values) {
            addCriterion("card_user not in", values, "cardUser");
            return (Criteria) this;
        }

        public Criteria andCardUserBetween(Long value1, Long value2) {
            addCriterion("card_user between", value1, value2, "cardUser");
            return (Criteria) this;
        }

        public Criteria andCardUserNotBetween(Long value1, Long value2) {
            addCriterion("card_user not between", value1, value2, "cardUser");
            return (Criteria) this;
        }

        public Criteria andCardNameIsNull() {
            addCriterion("card_name is null");
            return (Criteria) this;
        }

        public Criteria andCardNameIsNotNull() {
            addCriterion("card_name is not null");
            return (Criteria) this;
        }

        public Criteria andCardNameEqualTo(String value) {
            addCriterion("card_name =", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotEqualTo(String value) {
            addCriterion("card_name <>", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameGreaterThan(String value) {
            addCriterion("card_name >", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameGreaterThanOrEqualTo(String value) {
            addCriterion("card_name >=", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLessThan(String value) {
            addCriterion("card_name <", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLessThanOrEqualTo(String value) {
            addCriterion("card_name <=", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameLike(String value) {
            addCriterion("card_name like", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotLike(String value) {
            addCriterion("card_name not like", value, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameIn(List<String> values) {
            addCriterion("card_name in", values, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotIn(List<String> values) {
            addCriterion("card_name not in", values, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameBetween(String value1, String value2) {
            addCriterion("card_name between", value1, value2, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNameNotBetween(String value1, String value2) {
            addCriterion("card_name not between", value1, value2, "cardName");
            return (Criteria) this;
        }

        public Criteria andCardNumIsNull() {
            addCriterion("card_num is null");
            return (Criteria) this;
        }

        public Criteria andCardNumIsNotNull() {
            addCriterion("card_num is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumEqualTo(String value) {
            addCriterion("card_num =", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotEqualTo(String value) {
            addCriterion("card_num <>", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumGreaterThan(String value) {
            addCriterion("card_num >", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumGreaterThanOrEqualTo(String value) {
            addCriterion("card_num >=", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLessThan(String value) {
            addCriterion("card_num <", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLessThanOrEqualTo(String value) {
            addCriterion("card_num <=", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLike(String value) {
            addCriterion("card_num like", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotLike(String value) {
            addCriterion("card_num not like", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumIn(List<String> values) {
            addCriterion("card_num in", values, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotIn(List<String> values) {
            addCriterion("card_num not in", values, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumBetween(String value1, String value2) {
            addCriterion("card_num between", value1, value2, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotBetween(String value1, String value2) {
            addCriterion("card_num not between", value1, value2, "cardNum");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeIsNull() {
            addCriterion("consume_time is null");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeIsNotNull() {
            addCriterion("consume_time is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeEqualTo(Date value) {
            addCriterion("consume_time =", value, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeNotEqualTo(Date value) {
            addCriterion("consume_time <>", value, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeGreaterThan(Date value) {
            addCriterion("consume_time >", value, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("consume_time >=", value, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeLessThan(Date value) {
            addCriterion("consume_time <", value, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeLessThanOrEqualTo(Date value) {
            addCriterion("consume_time <=", value, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeIn(List<Date> values) {
            addCriterion("consume_time in", values, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeNotIn(List<Date> values) {
            addCriterion("consume_time not in", values, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeBetween(Date value1, Date value2) {
            addCriterion("consume_time between", value1, value2, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeNotBetween(Date value1, Date value2) {
            addCriterion("consume_time not between", value1, value2, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andCardMoneyIsNull() {
            addCriterion("card_money is null");
            return (Criteria) this;
        }

        public Criteria andCardMoneyIsNotNull() {
            addCriterion("card_money is not null");
            return (Criteria) this;
        }

        public Criteria andCardMoneyEqualTo(BigDecimal value) {
            addCriterion("card_money =", value, "cardMoney");
            return (Criteria) this;
        }

        public Criteria andCardMoneyNotEqualTo(BigDecimal value) {
            addCriterion("card_money <>", value, "cardMoney");
            return (Criteria) this;
        }

        public Criteria andCardMoneyGreaterThan(BigDecimal value) {
            addCriterion("card_money >", value, "cardMoney");
            return (Criteria) this;
        }

        public Criteria andCardMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("card_money >=", value, "cardMoney");
            return (Criteria) this;
        }

        public Criteria andCardMoneyLessThan(BigDecimal value) {
            addCriterion("card_money <", value, "cardMoney");
            return (Criteria) this;
        }

        public Criteria andCardMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("card_money <=", value, "cardMoney");
            return (Criteria) this;
        }

        public Criteria andCardMoneyIn(List<BigDecimal> values) {
            addCriterion("card_money in", values, "cardMoney");
            return (Criteria) this;
        }

        public Criteria andCardMoneyNotIn(List<BigDecimal> values) {
            addCriterion("card_money not in", values, "cardMoney");
            return (Criteria) this;
        }

        public Criteria andCardMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("card_money between", value1, value2, "cardMoney");
            return (Criteria) this;
        }

        public Criteria andCardMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("card_money not between", value1, value2, "cardMoney");
            return (Criteria) this;
        }

        public Criteria andCashMoneyIsNull() {
            addCriterion("cash_money is null");
            return (Criteria) this;
        }

        public Criteria andCashMoneyIsNotNull() {
            addCriterion("cash_money is not null");
            return (Criteria) this;
        }

        public Criteria andCashMoneyEqualTo(BigDecimal value) {
            addCriterion("cash_money =", value, "cashMoney");
            return (Criteria) this;
        }

        public Criteria andCashMoneyNotEqualTo(BigDecimal value) {
            addCriterion("cash_money <>", value, "cashMoney");
            return (Criteria) this;
        }

        public Criteria andCashMoneyGreaterThan(BigDecimal value) {
            addCriterion("cash_money >", value, "cashMoney");
            return (Criteria) this;
        }

        public Criteria andCashMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_money >=", value, "cashMoney");
            return (Criteria) this;
        }

        public Criteria andCashMoneyLessThan(BigDecimal value) {
            addCriterion("cash_money <", value, "cashMoney");
            return (Criteria) this;
        }

        public Criteria andCashMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_money <=", value, "cashMoney");
            return (Criteria) this;
        }

        public Criteria andCashMoneyIn(List<BigDecimal> values) {
            addCriterion("cash_money in", values, "cashMoney");
            return (Criteria) this;
        }

        public Criteria andCashMoneyNotIn(List<BigDecimal> values) {
            addCriterion("cash_money not in", values, "cashMoney");
            return (Criteria) this;
        }

        public Criteria andCashMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_money between", value1, value2, "cashMoney");
            return (Criteria) this;
        }

        public Criteria andCashMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_money not between", value1, value2, "cashMoney");
            return (Criteria) this;
        }

        public Criteria andCashSubsidyIsNull() {
            addCriterion("cash_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andCashSubsidyIsNotNull() {
            addCriterion("cash_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andCashSubsidyEqualTo(BigDecimal value) {
            addCriterion("cash_subsidy =", value, "cashSubsidy");
            return (Criteria) this;
        }

        public Criteria andCashSubsidyNotEqualTo(BigDecimal value) {
            addCriterion("cash_subsidy <>", value, "cashSubsidy");
            return (Criteria) this;
        }

        public Criteria andCashSubsidyGreaterThan(BigDecimal value) {
            addCriterion("cash_subsidy >", value, "cashSubsidy");
            return (Criteria) this;
        }

        public Criteria andCashSubsidyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_subsidy >=", value, "cashSubsidy");
            return (Criteria) this;
        }

        public Criteria andCashSubsidyLessThan(BigDecimal value) {
            addCriterion("cash_subsidy <", value, "cashSubsidy");
            return (Criteria) this;
        }

        public Criteria andCashSubsidyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_subsidy <=", value, "cashSubsidy");
            return (Criteria) this;
        }

        public Criteria andCashSubsidyIn(List<BigDecimal> values) {
            addCriterion("cash_subsidy in", values, "cashSubsidy");
            return (Criteria) this;
        }

        public Criteria andCashSubsidyNotIn(List<BigDecimal> values) {
            addCriterion("cash_subsidy not in", values, "cashSubsidy");
            return (Criteria) this;
        }

        public Criteria andCashSubsidyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_subsidy between", value1, value2, "cashSubsidy");
            return (Criteria) this;
        }

        public Criteria andCashSubsidyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_subsidy not between", value1, value2, "cashSubsidy");
            return (Criteria) this;
        }

        public Criteria andResponsibleUserIsNull() {
            addCriterion("responsible_user is null");
            return (Criteria) this;
        }

        public Criteria andResponsibleUserIsNotNull() {
            addCriterion("responsible_user is not null");
            return (Criteria) this;
        }

        public Criteria andResponsibleUserEqualTo(Long value) {
            addCriterion("responsible_user =", value, "responsibleUser");
            return (Criteria) this;
        }

        public Criteria andResponsibleUserNotEqualTo(Long value) {
            addCriterion("responsible_user <>", value, "responsibleUser");
            return (Criteria) this;
        }

        public Criteria andResponsibleUserGreaterThan(Long value) {
            addCriterion("responsible_user >", value, "responsibleUser");
            return (Criteria) this;
        }

        public Criteria andResponsibleUserGreaterThanOrEqualTo(Long value) {
            addCriterion("responsible_user >=", value, "responsibleUser");
            return (Criteria) this;
        }

        public Criteria andResponsibleUserLessThan(Long value) {
            addCriterion("responsible_user <", value, "responsibleUser");
            return (Criteria) this;
        }

        public Criteria andResponsibleUserLessThanOrEqualTo(Long value) {
            addCriterion("responsible_user <=", value, "responsibleUser");
            return (Criteria) this;
        }

        public Criteria andResponsibleUserIn(List<Long> values) {
            addCriterion("responsible_user in", values, "responsibleUser");
            return (Criteria) this;
        }

        public Criteria andResponsibleUserNotIn(List<Long> values) {
            addCriterion("responsible_user not in", values, "responsibleUser");
            return (Criteria) this;
        }

        public Criteria andResponsibleUserBetween(Long value1, Long value2) {
            addCriterion("responsible_user between", value1, value2, "responsibleUser");
            return (Criteria) this;
        }

        public Criteria andResponsibleUserNotBetween(Long value1, Long value2) {
            addCriterion("responsible_user not between", value1, value2, "responsibleUser");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameIsNull() {
            addCriterion("responsible_name is null");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameIsNotNull() {
            addCriterion("responsible_name is not null");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameEqualTo(String value) {
            addCriterion("responsible_name =", value, "responsibleName");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameNotEqualTo(String value) {
            addCriterion("responsible_name <>", value, "responsibleName");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameGreaterThan(String value) {
            addCriterion("responsible_name >", value, "responsibleName");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameGreaterThanOrEqualTo(String value) {
            addCriterion("responsible_name >=", value, "responsibleName");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameLessThan(String value) {
            addCriterion("responsible_name <", value, "responsibleName");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameLessThanOrEqualTo(String value) {
            addCriterion("responsible_name <=", value, "responsibleName");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameLike(String value) {
            addCriterion("responsible_name like", value, "responsibleName");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameNotLike(String value) {
            addCriterion("responsible_name not like", value, "responsibleName");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameIn(List<String> values) {
            addCriterion("responsible_name in", values, "responsibleName");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameNotIn(List<String> values) {
            addCriterion("responsible_name not in", values, "responsibleName");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameBetween(String value1, String value2) {
            addCriterion("responsible_name between", value1, value2, "responsibleName");
            return (Criteria) this;
        }

        public Criteria andResponsibleNameNotBetween(String value1, String value2) {
            addCriterion("responsible_name not between", value1, value2, "responsibleName");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIdIsNull() {
            addCriterion("invoice_type_id is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIdIsNotNull() {
            addCriterion("invoice_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIdEqualTo(Long value) {
            addCriterion("invoice_type_id =", value, "invoiceTypeId");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIdNotEqualTo(Long value) {
            addCriterion("invoice_type_id <>", value, "invoiceTypeId");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIdGreaterThan(Long value) {
            addCriterion("invoice_type_id >", value, "invoiceTypeId");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("invoice_type_id >=", value, "invoiceTypeId");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIdLessThan(Long value) {
            addCriterion("invoice_type_id <", value, "invoiceTypeId");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("invoice_type_id <=", value, "invoiceTypeId");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIdIn(List<Long> values) {
            addCriterion("invoice_type_id in", values, "invoiceTypeId");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIdNotIn(List<Long> values) {
            addCriterion("invoice_type_id not in", values, "invoiceTypeId");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIdBetween(Long value1, Long value2) {
            addCriterion("invoice_type_id between", value1, value2, "invoiceTypeId");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("invoice_type_id not between", value1, value2, "invoiceTypeId");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("invoice_type is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("invoice_type is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeEqualTo(String value) {
            addCriterion("invoice_type =", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotEqualTo(String value) {
            addCriterion("invoice_type <>", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThan(String value) {
            addCriterion("invoice_type >", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_type >=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThan(String value) {
            addCriterion("invoice_type <", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(String value) {
            addCriterion("invoice_type <=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLike(String value) {
            addCriterion("invoice_type like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotLike(String value) {
            addCriterion("invoice_type not like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIn(List<String> values) {
            addCriterion("invoice_type in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotIn(List<String> values) {
            addCriterion("invoice_type not in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeBetween(String value1, String value2) {
            addCriterion("invoice_type between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotBetween(String value1, String value2) {
            addCriterion("invoice_type not between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(String value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(String value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(String value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(String value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(String value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(String value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLike(String value) {
            addCriterion("month like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotLike(String value) {
            addCriterion("month not like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<String> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<String> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(String value1, String value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(String value1, String value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andRefundIsNull() {
            addCriterion("refund is null");
            return (Criteria) this;
        }

        public Criteria andRefundIsNotNull() {
            addCriterion("refund is not null");
            return (Criteria) this;
        }

        public Criteria andRefundEqualTo(String value) {
            addCriterion("refund =", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotEqualTo(String value) {
            addCriterion("refund <>", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundGreaterThan(String value) {
            addCriterion("refund >", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundGreaterThanOrEqualTo(String value) {
            addCriterion("refund >=", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLessThan(String value) {
            addCriterion("refund <", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLessThanOrEqualTo(String value) {
            addCriterion("refund <=", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLike(String value) {
            addCriterion("refund like", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotLike(String value) {
            addCriterion("refund not like", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundIn(List<String> values) {
            addCriterion("refund in", values, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotIn(List<String> values) {
            addCriterion("refund not in", values, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundBetween(String value1, String value2) {
            addCriterion("refund between", value1, value2, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotBetween(String value1, String value2) {
            addCriterion("refund not between", value1, value2, "refund");
            return (Criteria) this;
        }

        public Criteria andReceivingTimeIsNull() {
            addCriterion("receiving_time is null");
            return (Criteria) this;
        }

        public Criteria andReceivingTimeIsNotNull() {
            addCriterion("receiving_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceivingTimeEqualTo(Date value) {
            addCriterion("receiving_time =", value, "receivingTime");
            return (Criteria) this;
        }

        public Criteria andReceivingTimeNotEqualTo(Date value) {
            addCriterion("receiving_time <>", value, "receivingTime");
            return (Criteria) this;
        }

        public Criteria andReceivingTimeGreaterThan(Date value) {
            addCriterion("receiving_time >", value, "receivingTime");
            return (Criteria) this;
        }

        public Criteria andReceivingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receiving_time >=", value, "receivingTime");
            return (Criteria) this;
        }

        public Criteria andReceivingTimeLessThan(Date value) {
            addCriterion("receiving_time <", value, "receivingTime");
            return (Criteria) this;
        }

        public Criteria andReceivingTimeLessThanOrEqualTo(Date value) {
            addCriterion("receiving_time <=", value, "receivingTime");
            return (Criteria) this;
        }

        public Criteria andReceivingTimeIn(List<Date> values) {
            addCriterion("receiving_time in", values, "receivingTime");
            return (Criteria) this;
        }

        public Criteria andReceivingTimeNotIn(List<Date> values) {
            addCriterion("receiving_time not in", values, "receivingTime");
            return (Criteria) this;
        }

        public Criteria andReceivingTimeBetween(Date value1, Date value2) {
            addCriterion("receiving_time between", value1, value2, "receivingTime");
            return (Criteria) this;
        }

        public Criteria andReceivingTimeNotBetween(Date value1, Date value2) {
            addCriterion("receiving_time not between", value1, value2, "receivingTime");
            return (Criteria) this;
        }

        public Criteria andReceivedTimeIsNull() {
            addCriterion("received_time is null");
            return (Criteria) this;
        }

        public Criteria andReceivedTimeIsNotNull() {
            addCriterion("received_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedTimeEqualTo(Date value) {
            addCriterion("received_time =", value, "receivedTime");
            return (Criteria) this;
        }

        public Criteria andReceivedTimeNotEqualTo(Date value) {
            addCriterion("received_time <>", value, "receivedTime");
            return (Criteria) this;
        }

        public Criteria andReceivedTimeGreaterThan(Date value) {
            addCriterion("received_time >", value, "receivedTime");
            return (Criteria) this;
        }

        public Criteria andReceivedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("received_time >=", value, "receivedTime");
            return (Criteria) this;
        }

        public Criteria andReceivedTimeLessThan(Date value) {
            addCriterion("received_time <", value, "receivedTime");
            return (Criteria) this;
        }

        public Criteria andReceivedTimeLessThanOrEqualTo(Date value) {
            addCriterion("received_time <=", value, "receivedTime");
            return (Criteria) this;
        }

        public Criteria andReceivedTimeIn(List<Date> values) {
            addCriterion("received_time in", values, "receivedTime");
            return (Criteria) this;
        }

        public Criteria andReceivedTimeNotIn(List<Date> values) {
            addCriterion("received_time not in", values, "receivedTime");
            return (Criteria) this;
        }

        public Criteria andReceivedTimeBetween(Date value1, Date value2) {
            addCriterion("received_time between", value1, value2, "receivedTime");
            return (Criteria) this;
        }

        public Criteria andReceivedTimeNotBetween(Date value1, Date value2) {
            addCriterion("received_time not between", value1, value2, "receivedTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeIsNull() {
            addCriterion("account_time is null");
            return (Criteria) this;
        }

        public Criteria andAccountTimeIsNotNull() {
            addCriterion("account_time is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTimeEqualTo(Date value) {
            addCriterion("account_time =", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeNotEqualTo(Date value) {
            addCriterion("account_time <>", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeGreaterThan(Date value) {
            addCriterion("account_time >", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("account_time >=", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeLessThan(Date value) {
            addCriterion("account_time <", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeLessThanOrEqualTo(Date value) {
            addCriterion("account_time <=", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeIn(List<Date> values) {
            addCriterion("account_time in", values, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeNotIn(List<Date> values) {
            addCriterion("account_time not in", values, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeBetween(Date value1, Date value2) {
            addCriterion("account_time between", value1, value2, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeNotBetween(Date value1, Date value2) {
            addCriterion("account_time not between", value1, value2, "accountTime");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNull() {
            addCriterion("purpose is null");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNotNull() {
            addCriterion("purpose is not null");
            return (Criteria) this;
        }

        public Criteria andPurposeEqualTo(String value) {
            addCriterion("purpose =", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotEqualTo(String value) {
            addCriterion("purpose <>", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThan(String value) {
            addCriterion("purpose >", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("purpose >=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThan(String value) {
            addCriterion("purpose <", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThanOrEqualTo(String value) {
            addCriterion("purpose <=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLike(String value) {
            addCriterion("purpose like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotLike(String value) {
            addCriterion("purpose not like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeIn(List<String> values) {
            addCriterion("purpose in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotIn(List<String> values) {
            addCriterion("purpose not in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeBetween(String value1, String value2) {
            addCriterion("purpose between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotBetween(String value1, String value2) {
            addCriterion("purpose not between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}