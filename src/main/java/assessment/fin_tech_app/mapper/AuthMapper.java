package assessment.fin_tech_app.mapper;

import assessment.fin_tech_app.controller.dto.request.RegisterRequest;
import assessment.fin_tech_app.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    @Mapping(target = "password", ignore = true)
    User toEntity(RegisterRequest request);
}
