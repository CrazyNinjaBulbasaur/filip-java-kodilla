package com.kodilla.invoice.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class SimpleInvoice {

    private final List<SimpleItem> items = new ArrayList<>();

    public void addItem(SimpleItem item) {
        items.add(item);
    }

    public boolean removeItem(SimpleItem item) {
        return items.remove(item);
    }

    /**
            Using a new collector here Collectors.summingDouble(ToDoubleFunction mapper)
     */
    public double getValueToPay() {
        return items.stream()
                .collect(Collectors.summingDouble(SimpleItem::getValue));
    }
}
