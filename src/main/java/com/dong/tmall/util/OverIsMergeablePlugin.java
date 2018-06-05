package com.dong.tmall.util;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

//防止第一次生成了CategoryMapper.xml之后，再次运行会导致CategoryMapper.xml生成重复内容的bug
public class OverIsMergeablePlugin extends PluginAdapter{
    @Override
    public boolean validate(List<String> warnings){
        return true;
    }
    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable){
        try{
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
