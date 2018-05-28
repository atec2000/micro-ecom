package com.microecom.mecordercommand.mapper;


import com.microecom.mecordercommand.model.LineItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LineItemMapper {

	int insert(LineItem lineItem);

}
