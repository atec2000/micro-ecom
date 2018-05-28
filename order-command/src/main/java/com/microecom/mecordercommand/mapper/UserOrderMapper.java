package com.microecom.mecordercommand.mapper;

import com.microecom.mecordercommand.model.UserOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserOrderMapper {

	int insert(UserOrder userOrder);

}
