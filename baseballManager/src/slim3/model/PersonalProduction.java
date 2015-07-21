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

    /** �P�� */
    private int singleHit;

    /** ��ۑ� */
    private int twoBaseHit;

    /** �O�ۑ� */
    private int threeBaseHit;

    /** �{�ۑ� */
    private int homeRun;

    /** �œ_ */
    private int runBatted;

    /** ���_ */
    private int points;

    /** ���� */
    private int baseStealing;

    /** �l�� */
    private int fourBalls;

    /** ���� */
    private int deadBall;

    /** �O�U */
    private int strikeout;

    /** �]�� */
    private int sacrificeHit;

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
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
