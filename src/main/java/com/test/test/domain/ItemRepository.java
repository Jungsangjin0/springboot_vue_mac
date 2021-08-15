package com.test.test.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepository {

    private final Map<Long, Item> store = new HashMap<>();
    private long sequence = 0L;

    /**
     * 파라미터로 전달받은 item 값에 시퀀스를 설정하고 해당 시퀀스 기준으로(key)로
     * map에 저장 key(sequence), value(item)
     * @param item
     * @return
     */
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

}
