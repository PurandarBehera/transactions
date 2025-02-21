package com.puru.springboot.transactions.response;

import com.puru.springboot.transactions.entity.Order;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponsePage {

    private List<Order> content;
    private int pageNo;
    private int pageSize;
    private long totalOrders;
    private int totalPages;
    private boolean isLastPage;

}
