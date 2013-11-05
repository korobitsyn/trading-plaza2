package trading.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.sql.Time;


/**
 * The persistent class for the level1 database table.
 * 
 */
@Entity
//@NamedQuery(name="Level1.findAll", query="SELECT l FROM Level1 l")
public class Level1 implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer ask;
	private Integer askSize;
	private double bid;
	private Integer bidSize;
	private Timestamp date;
	private double lastPrice;
	private float lastPriceDelta;
	private Integer lastSize;
	private Time lastTime;
	private Instrument instrument;

	public Level1() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getAsk() {
		return this.ask;
	}

	public void setAsk(Integer ask) {
		this.ask = ask;
	}


	@Column(name="ask_size")
	public Integer getAskSize() {
		return this.askSize;
	}

	public void setAskSize(Integer askSize) {
		this.askSize = askSize;
	}


	public double getBid() {
		return this.bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}


	@Column(name="bid_size")
	public Integer getBidSize() {
		return this.bidSize;
	}

	public void setBidSize(Integer bidSize) {
		this.bidSize = bidSize;
	}


	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}


	@Column(name="last_price")
	public double getLastPrice() {
		return this.lastPrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}


	@Column(name="last_price_delta")
	public float getLastPriceDelta() {
		return this.lastPriceDelta;
	}

	public void setLastPriceDelta(float lastPriceDelta) {
		this.lastPriceDelta = lastPriceDelta;
	}


	@Column(name="last_size")
	public Integer getLastSize() {
		return this.lastSize;
	}

	public void setLastSize(Integer lastSize) {
		this.lastSize = lastSize;
	}


	@Column(name="last_time")
	public Time getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Time lastTime) {
		this.lastTime = lastTime;
	}


	//bi-directional many-to-one association to Instrument
	@ManyToOne
	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}