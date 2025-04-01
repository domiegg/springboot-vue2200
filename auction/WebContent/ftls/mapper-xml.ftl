<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.ognice.dao.${bean.name?cap_first}Mapper">
	<resultMap id="BaseResultMap" type="com.ognice.domain.${bean.name?cap_first}">
		<id column="id" property="id" jdbcType="BIGINT" />
<#list bean.attrs as attr>
		<#if attr.dbname!="id">
		<result column="${attr.dbname}" property="${attr.dbname}" jdbcType="${attr.dtype}" />
		</#if>
</#list>
	</resultMap>
	<sql id="Base_Column_List">
<#list bean.attrs as attr>
		`${attr.dbname}`
		<#if attr_has_next>,</#if>
</#list>
	</sql>
	<select id="select${bean.name?cap_first}ById" resultMap="BaseResultMap" parameterType="java.lang.Long">
		select
		<include refid="Base_Column_List" />
		from ${bean.name} where id = ${r"#{id,jdbcType=BIGINT}"}
	</select>
	<select id="page" parameterType="com.ognice.controller.common.PageSearchParam" resultMap="BaseResultMap">
		select
		<include refid="Base_Column_List" />
		from ${bean.name} where 1=1
		<if test="params!=null">
<#list bean.attrs as attr>
<#if attr.jtype=="String">
		<if test="params.${attr.jname?uncap_first} !=null and params.${attr.jname?uncap_first}!=''">
		 AND `${attr.dbname}` like concat('%',${r"#{params."}${attr.jname?uncap_first}${r"}"},'%')
		</if>
<#else>
		<if test="params.${attr.jname?uncap_first} !=null and params.${attr.jname?uncap_first}!=''">
		AND `${attr.dbname}` = ${r"#{params."}${attr.jname?uncap_first}${r"}"}
		</if>
</#if>
</#list>
		</if>
		order by id desc
		<if test="page!=null"> limit ${r"#{page},#{pagesize}"}
		</if>
	</select>

	<delete id="delete" parameterType="java.lang.Long"> delete from ${bean.name} where id = ${r"#{id,jdbcType=BIGINT}"}
	</delete>
	<insert id="insert" parameterType="com.ognice.domain.${bean.name?cap_first}"> insert into ${bean.name} (
<#list bean.attrs as attr>
		`${attr.dbname}`
				<#if attr_has_next>,</#if>
</#list>
	) values (
<#list bean.attrs as attr>
		${r"#{"}${attr.jname?uncap_first}${r",jdbcType="}${attr.dtype}${r"}"}
				<#if attr_has_next>,</#if>
</#list>
	)
	</insert>

	<update id="update" parameterType="com.ognice.domain.${bean.name?cap_first}">
		update ${bean.name}
		<set>
		<#list bean.attrs as attr>
		<if test="${attr.jname?uncap_first} != null">
		`${attr.dbname}`= ${r"#{"}${attr.jname?uncap_first}${r",jdbcType="}${attr.dtype}${r"},"}
		</if>
		</#list>
		</set>
		where id = ${r"#{id,jdbcType=BIGINT}"}
	</update>

</mapper>