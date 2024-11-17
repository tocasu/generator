package com.gm.iot.hub.web.mapper;

import com.gm.iot.hub.model.test.DataTestOptions;
import com.gm.iot.hub.web.dto.DataTestOptionsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto> {

}
