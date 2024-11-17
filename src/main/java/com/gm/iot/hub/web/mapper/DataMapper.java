package com.gm.iot.hub.web.mapper;

import com.gm.iot.hub.model.Data;
import com.gm.iot.hub.web.dto.DataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {

}
