package com.craft.interview.utils;

import java.util.*;

public class RateLimiter {
    // A map to store the list of timestamps for each key
    private final Map<String, List<Long>> requestMap = new HashMap<>();

    /**
     * Method to check if a request is within the rate limit
     * 
     * @param key     The unique key to identify the requests
     * @param period  The time period in seconds
     * @param maxCalls The maximum number of allowed calls within the period
     * @return true if the request is allowed, false otherwise
     */
    public boolean rateLimit(String key, int period, int maxCalls) {
        long currentTime = System.currentTimeMillis() / 1000; // Convert to seconds
        requestMap.putIfAbsent(key, new ArrayList<>());

        List<Long> timestamps = requestMap.get(key);

        // Remove timestamps that are outside the time period window
        while (!timestamps.isEmpty() && timestamps.get(0) < currentTime - period) {
            timestamps.remove(0);
        }

        // Check the number of requests in the current window
        if (timestamps.size() >= maxCalls) {
            return false;
        }

        // Add the current timestamp to the list
        timestamps.add(currentTime);

        return true;
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter();

        System.out.println(rateLimiter.rateLimit("device_info", 30, 3)); // true
        System.out.println(rateLimiter.rateLimit("device_info", 30, 3)); // true
        System.out.println(rateLimiter.rateLimit("device_info", 30, 3)); // true
        System.out.println(rateLimiter.rateLimit("device_info", 30, 3)); // false
    }
}
