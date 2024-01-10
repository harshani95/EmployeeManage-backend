package com.devstack.employeemanage.dto.response.paginated;

import com.devstack.employeemanage.dto.response.ResponseEmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedEmployeeResponseDto {
    private long count;
    private List<ResponseEmployeeDto> dataList;
}
