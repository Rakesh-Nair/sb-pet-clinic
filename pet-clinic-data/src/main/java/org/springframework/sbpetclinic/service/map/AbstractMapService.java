package org.springframework.sbpetclinic.service.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.sbpetclinic.model.BaseEntity;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {
	protected Map<Long, T> map = new HashMap<>();

	Set<T> findAll() {
		return new HashSet<T>(map.values());
	}

	T findById(ID id) {
		return map.get(id);
	}

	T save(T t) {
		if (t != null) {
			if (t.getId() == null) {
				t.setId(getNextId());
			}
			map.put(t.getId(), t);
		} else {
			throw new RuntimeException("Object cannot be null");
		}
		return t;
	}

	void deleteById(ID id) {
		map.remove(id);
	}

	void delete(T t) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(t));
	}

	private Long getNextId() {
		Long nextId = null;
		try {
			nextId = Collections.max(map.keySet()) + 1;
		} catch (NoSuchElementException e) {
			nextId = 1L;
		}
		return nextId;
	}
}
