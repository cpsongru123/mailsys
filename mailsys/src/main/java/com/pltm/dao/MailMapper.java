package com.pltm.dao;

import com.pltm.dto.Mail;
import com.pltm.dto.MailExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    @SelectProvider(type=MailSqlProvider.class, method="countByExample")
    int countByExample(MailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    @DeleteProvider(type=MailSqlProvider.class, method="deleteByExample")
    int deleteByExample(MailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    @Delete({
        "delete from mail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    @Insert({
        "insert into mail (id, mail_acc, ",
        "mail_auth, username, ",
        "mail_host_name)",
        "values (#{id,jdbcType=INTEGER}, #{mailAcc,jdbcType=VARCHAR}, ",
        "#{mailAuth,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, ",
        "#{mailHostName,jdbcType=VARCHAR})"
    })
    int insert(Mail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    @InsertProvider(type=MailSqlProvider.class, method="insertSelective")
    int insertSelective(Mail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    @SelectProvider(type=MailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mail_acc", property="mailAcc", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_auth", property="mailAuth", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_host_name", property="mailHostName", jdbcType=JdbcType.VARCHAR)
    })
    List<Mail> selectByExample(MailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    @Select({
        "select",
        "id, mail_acc, mail_auth, username, mail_host_name",
        "from mail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mail_acc", property="mailAcc", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_auth", property="mailAuth", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="mail_host_name", property="mailHostName", jdbcType=JdbcType.VARCHAR)
    })
    Mail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    @UpdateProvider(type=MailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Mail record, @Param("example") MailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    @UpdateProvider(type=MailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Mail record, @Param("example") MailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    @UpdateProvider(type=MailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Mail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mail
     *
     * @mbggenerated Mon Mar 19 23:50:15 CST 2018
     */
    @Update({
        "update mail",
        "set mail_acc = #{mailAcc,jdbcType=VARCHAR},",
          "mail_auth = #{mailAuth,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "mail_host_name = #{mailHostName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Mail record);
}