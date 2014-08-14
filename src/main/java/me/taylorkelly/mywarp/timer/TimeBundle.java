package me.taylorkelly.mywarp.timer;

import java.util.EnumMap;
import java.util.Map;

import me.taylorkelly.mywarp.permissions.valuebundles.AbstractValueBundle;

/**
 * A bundle that stores times for timers.
 */
public class TimeBundle extends AbstractValueBundle {

    /**
     * The different types of times.
     */
    public enum Time {
        WARP_WARMUP, WARP_COOLDOWN
    }

    private Map<Time, Double> times = new EnumMap<Time, Double>(Time.class);

    /**
     * Initializes this limit-bundle.
     * 
     * @param identifier
     *            the unique identifier
     * @param warpCooldown
     *            the cooldown when using a warp
     * @param warpWarmup
     *            the warmup when using a warp
     **/
    public TimeBundle(String identifier, double warpCooldown, double warpWarmup) {
        super(identifier);
        times.put(Time.WARP_COOLDOWN, warpCooldown);
        times.put(Time.WARP_WARMUP, warpWarmup);
    }

    /**
     * Gets the value of the given time in seconds.
     * 
     * @param time
     *            the time
     * @return the value in seconds
     */
    public double getSeconds(Time time) {
        return times.get(time);
    }

    /**
     * Gets the value of the given time in ticks.
     * 
     * @param time
     *            the time
     * @return the value in ticks
     */
    public long getTicks(Time time) {
        return (long) (getSeconds(time) * 20);
    }

    @Override
    protected String getBasePermission() {
        return "mywarp.timer";
    }

    @Override
    public String toString() {
        return "TimeBundle [getIdentifier()=" + getIdentifier() + ", times=" + times + "]";
    }

}
