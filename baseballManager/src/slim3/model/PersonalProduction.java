package slim3.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class PersonalProduction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /** 単打  */
    private Integer singleHit;

    /** 二塁打   */
    private Integer twoBaseHit;

    /** 三塁打   */
    private Integer threeBaseHit;

    /** 本塁打  */
    private Integer homeRun;

    /** 打点  */
    private Integer runBatted;

    /** 得点   */
    private Integer scoring;

    /** 盗塁   */
    private Integer baseStealing;

    /** 四球   */
    private Integer fourBalls;

    /** 死球  */
    private Integer deadBall;

    /** 三振   */
    private Integer strikeout;

    /** 犠打    */
    private Integer bunt;

    /** 犠飛    */
    private Integer sacrificeFly;

    /** 進塁打    */
    private Integer productiveOut;

    /** 野選     */
    private Integer FieldersChoice;

    /** 併殺     */
    private Integer dublePlay;

    /** 失策  */
    private Integer blunder;

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    public Integer getSingleHit() {
        return singleHit;
    }

    public void setSingleHit(Integer singleHit) {
        this.singleHit = singleHit;
    }

    public Integer getTwoBaseHit() {
        return twoBaseHit;
    }

    public void setTwoBaseHit(Integer twoBaseHit) {
        this.twoBaseHit = twoBaseHit;
    }

    public Integer getThreeBaseHit() {
        return threeBaseHit;
    }

    public void setThreeBaseHit(Integer threeBaseHit) {
        this.threeBaseHit = threeBaseHit;
    }

    public Integer getHomeRun() {
        return homeRun;
    }

    public void setHomeRun(Integer homeRun) {
        this.homeRun = homeRun;
    }

    public Integer getRunBatted() {
        return runBatted;
    }

    public void setRunBatted(Integer runBatted) {
        this.runBatted = runBatted;
    }

    public Integer getScoring() {
        return scoring;
    }

    public void setScoring(Integer scoring) {
        this.scoring = scoring;
    }

    public Integer getBaseStealing() {
        return baseStealing;
    }

    public void setBaseStealing(Integer baseStealing) {
        this.baseStealing = baseStealing;
    }

    public Integer getFourBalls() {
        return fourBalls;
    }

    public void setFourBalls(Integer fourBalls) {
        this.fourBalls = fourBalls;
    }

    public Integer getDeadBall() {
        return deadBall;
    }

    public void setDeadBall(Integer deadBall) {
        this.deadBall = deadBall;
    }

    public Integer getStrikeout() {
        return strikeout;
    }

    public void setStrikeout(Integer strikeout) {
        this.strikeout = strikeout;
    }

    public Integer getBunt() {
        return bunt;
    }

    public void setBunt(Integer bunt) {
        this.bunt = bunt;
    }

    public Integer getSacrificeFly() {
        return sacrificeFly;
    }

    public void setSacrificeFly(Integer sacrificeFly) {
        this.sacrificeFly = sacrificeFly;
    }

    public Integer getProductiveOut() {
        return productiveOut;
    }

    public void setProductiveOut(Integer productiveOut) {
        this.productiveOut = productiveOut;
    }

    public Integer getFieldersChoice() {
        return FieldersChoice;
    }

    public void setFieldersChoice(Integer fieldersChoice) {
        FieldersChoice = fieldersChoice;
    }

    public Integer getDublePlay() {
        return dublePlay;
    }

    public void setDublePlay(Integer dublePlay) {
        this.dublePlay = dublePlay;
    }

    public Integer getBlunder() {
        return blunder;
    }

    public void setBlunder(Integer blunder) {
        this.blunder = blunder;
    }


    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PersonalProduction other = (PersonalProduction) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public int getSingleHit() {
        return singleHit;
    }

    public void setSingleHit(int singleHit) {
        this.singleHit = singleHit;
    }

    public int getTwoBaseHit() {
        return twoBaseHit;
    }

    public void setTwoBaseHit(int twoBaseHit) {
        this.twoBaseHit = twoBaseHit;
    }

    public int getThreeBaseHit() {
        return threeBaseHit;
    }

    public void setThreeBaseHit(int threeBaseHit) {
        this.threeBaseHit = threeBaseHit;
    }

    public int getHomeRun() {
        return homeRun;
    }

    public void setHomeRun(int homeRun) {
        this.homeRun = homeRun;
    }

    public int getRunBatted() {
        return runBatted;
    }

    public void setRunBatted(int runBatted) {
        this.runBatted = runBatted;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getBaseStealing() {
        return baseStealing;
    }

    public void setBaseStealing(int baseStealing) {
        this.baseStealing = baseStealing;
    }

    public int getFourBalls() {
        return fourBalls;
    }

    public void setFourBalls(int fourBalls) {
        this.fourBalls = fourBalls;
    }

    public int getDeadBall() {
        return deadBall;
    }

    public void setDeadBall(int deadBall) {
        this.deadBall = deadBall;
    }

    public int getStrikeout() {
        return strikeout;
    }

    public void setStrikeout(int strikeout) {
        this.strikeout = strikeout;
    }

    public int getSacrificeHit() {
        return sacrificeHit;
    }

    public void setSacrificeHit(int sacrificeHit) {
        this.sacrificeHit = sacrificeHit;
    }
}
