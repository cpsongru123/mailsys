package com.pltm.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.pltm.dto.MailHost;
import com.pltm.dto.MailHostExample.Criteria;
import com.pltm.dto.MailHostExample.Criterion;
import com.pltm.dto.MailHostExample;
import java.util.List;
import java.util.Map;

public class MailHostSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public String countByExample(MailHostExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("mail_host");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public String deleteByExample(MailHostExample example) {
        BEGIN();
        DELETE_FROM("mail_host");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public String insertSelective(MailHost record) {
        BEGIN();
        INSERT_INTO("mail_host");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getHostName() != null) {
            VALUES("host_name", "#{hostName,jdbcType=VARCHAR}");
        }
        
        if (record.getSmtpHost() != null) {
            VALUES("smtp_host", "#{smtpHost,jdbcType=VARCHAR}");
        }
        
        if (record.getSmtpHostPort() != null) {
            VALUES("smtp_host_port", "#{smtpHostPort,jdbcType=VARCHAR}");
        }
        
        if (record.getPop3Host() != null) {
            VALUES("pop3_host", "#{pop3Host,jdbcType=VARCHAR}");
        }
        
        if (record.getPop3HostPort() != null) {
            VALUES("pop3_host_port", "#{pop3HostPort,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public String selectByExample(MailHostExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("host_name");
        SELECT("smtp_host");
        SELECT("smtp_host_port");
        SELECT("pop3_host");
        SELECT("pop3_host_port");
        FROM("mail_host");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        MailHost record = (MailHost) parameter.get("record");
        MailHostExample example = (MailHostExample) parameter.get("example");
        
        BEGIN();
        UPDATE("mail_host");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getHostName() != null) {
            SET("host_name = #{record.hostName,jdbcType=VARCHAR}");
        }
        
        if (record.getSmtpHost() != null) {
            SET("smtp_host = #{record.smtpHost,jdbcType=VARCHAR}");
        }
        
        if (record.getSmtpHostPort() != null) {
            SET("smtp_host_port = #{record.smtpHostPort,jdbcType=VARCHAR}");
        }
        
        if (record.getPop3Host() != null) {
            SET("pop3_host = #{record.pop3Host,jdbcType=VARCHAR}");
        }
        
        if (record.getPop3HostPort() != null) {
            SET("pop3_host_port = #{record.pop3HostPort,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("mail_host");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("host_name = #{record.hostName,jdbcType=VARCHAR}");
        SET("smtp_host = #{record.smtpHost,jdbcType=VARCHAR}");
        SET("smtp_host_port = #{record.smtpHostPort,jdbcType=VARCHAR}");
        SET("pop3_host = #{record.pop3Host,jdbcType=VARCHAR}");
        SET("pop3_host_port = #{record.pop3HostPort,jdbcType=VARCHAR}");
        
        MailHostExample example = (MailHostExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    public String updateByPrimaryKeySelective(MailHost record) {
        BEGIN();
        UPDATE("mail_host");
        
        if (record.getHostName() != null) {
            SET("host_name = #{hostName,jdbcType=VARCHAR}");
        }
        
        if (record.getSmtpHost() != null) {
            SET("smtp_host = #{smtpHost,jdbcType=VARCHAR}");
        }
        
        if (record.getSmtpHostPort() != null) {
            SET("smtp_host_port = #{smtpHostPort,jdbcType=VARCHAR}");
        }
        
        if (record.getPop3Host() != null) {
            SET("pop3_host = #{pop3Host,jdbcType=VARCHAR}");
        }
        
        if (record.getPop3HostPort() != null) {
            SET("pop3_host_port = #{pop3HostPort,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail_host
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    protected void applyWhere(MailHostExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}