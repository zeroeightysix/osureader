package me.zeroeightysix.osureader.section;

/**
 * Created by 086 on 16/05/2018.
 */
public class DifficultySection extends Section {

    @Source("HPDrainRate") private int hpDrainRate;
    @Source("CircleSize") private int circleSize;
    @Source("OverallDifficulty") private int overallDifficulty;
    @Source("ApproachRate") private int approachRate;

    public DifficultySection(OsuSection source) throws IllegalAccessException {
        super(source);
    }

    public int getApproachRate() {
        return approachRate;
    }

    public int getCircleSize() {
        return circleSize;
    }

    /**
     * Returns the circle radius in osu!pixels
     * @return
     */
    public double getCircleRadius() {
        return 32 * (1 - 0.7 * (getCircleSize() - 5) / 5);
    }

    public int getHpDrainRate() {
        return hpDrainRate;
    }

    public int getOverallDifficulty() {
        return overallDifficulty;
    }

}
