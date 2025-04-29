package com.example.Staff_Management_System.service;

import com.example.Staff_Management_System.model.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StaffService {

    private Map<Long, Staff> staffMap = new ConcurrentHashMap<>();
    private AtomicLong idCounter = new AtomicLong();

    public List<Staff> getAllStaff() {
        return new ArrayList<>(staffMap.values());
    }

    public Staff getStaffById(Long id) {
        return staffMap.get(id);
    }

    public Staff createStaff(Staff staff) {
        long id = idCounter.incrementAndGet();
        staff.setId(id);
        staffMap.put(id, staff);
        return staff;
    }

    public Staff updateStaff(Long id, Staff staff) {
        staff.setId(id);
        staffMap.put(id, staff);
        return staff;
    }

    public void deleteStaff(Long id) {
        staffMap.remove(id);
    }
}

