package assessment.fin_tech_app.mapper;

import assessment.fin_tech_app.controller.dto.request.RegisterRequest;
import assessment.fin_tech_app.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    User toEntity(RegisterRequest request);
}
