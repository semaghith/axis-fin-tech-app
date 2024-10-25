package assessment.fin_tech_app.mapper;

import assessment.fin_tech_app.controller.dto.response.TransactionResponse;
import assessment.fin_tech_app.entity.Transaction;
import assessment.fin_tech_app.entity.enums.TransactionType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "transactionId", source = "id")
    @Mapping(target = "transactionType", source = "type", qualifiedByName = "mapTransactionType")
    TransactionResponse toResponse(Transaction transaction);

    @Named("mapTransactionType")
    default String mapTransactionType(TransactionType type) {
        return type != null ? type.getStatus() : null;
    }
}
