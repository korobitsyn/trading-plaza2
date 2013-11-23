	package trading.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the level1 database table.
 * 
 */
@Entity
@NamedQueries(value = { 
		@NamedQuery(name=trading.data.Constants.QueryName.LEVEL1_FIND_RANGE, query="SELECT l FROM Level1 l WHERE l.instrument.id = :" + trading.data.Constants.QueryParamName.INSTRUMENT_ID + " AND l.date  BETWEEN :" + trading.data.Constants.QueryParamName.START_TIME + " AND :" + trading.data.Constants.QueryParamName.END_TIME + " ORDER BY l.date")
})
@NamedNativeQueries(value={
		@NamedNativeQuery(resultClass=Level1.class, name=trading.data.Constants.QueryName.LEVEL1_FIND_LAST, query="SELECT level1.* FROM (SELECT * FROM level1 WHERE instrument_id = :" + trading.data.Constants.QueryParamName.INSTRUMENT_ID + " ORDER BY date DESC LIMIT :" + trading.data.Constants.QueryParamName.COUNT + ") AS level1 ORDER BY level1.date ASC")
})
public class Level1 implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private BigDecimal ask;
	private Integer askSize;
	private BigDecimal bid;
	private Integer bidSize;
	private Date date;
	private BigDecimal lastPrice;
	private BigDecimal lastPriceDelta;
	private Integer lastSize;
	private Date lastTime;
	private Instrument instrument;

	public Level1() {
	}
	/**
	 * Construct level1 from price and size values
	 * @param date
	 * @param price
	 * @param size
	 * @param bid
	 * @param bidSize
	 * @param ask
	 * @param askSize
	 */
	public Level1(Date date, BigDecimal price, Integer size, BigDecimal bid, Integer bidSize, BigDecimal ask, Integer askSize){
		// Today's day date and time
		Calendar dayCal = GregorianCalendar.getInstance(); 
		dayCal.setTimeInMillis(date.getTime());
		this.date = dayCal.getTime();
		
		// Time inside day
		Calendar timeOfDayCal = GregorianCalendar.getInstance();
		timeOfDayCal.setTimeInMillis(date.getTime());
		timeOfDayCal.set(Calendar.DAY_OF_YEAR, 1);
		timeOfDayCal.set(Calendar.YEAR, 0);
		this.lastTime = timeOfDayCal.getTime();
		
		this.lastPrice = price;
		this.lastSize = size;
		this.bid = bid;
		this.bidSize = bidSize;
		this.ask = ask;
		this.askSize = askSize;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public BigDecimal getAsk() {
		return this.ask;
	}

	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}


	@Column(name="ask_size")
	public Integer getAskSize() {
		return this.askSize;
	}

	public void setAskSize(Integer askSize) {
		this.askSize = askSize;
	}


	public BigDecimal getBid() {
		return this.bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}


	@Column(name="bid_size")
	public Integer getBidSize() {
		return this.bidSize;
	}

	public void setBidSize(Integer bidSize) {
		this.bidSize = bidSize;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Column(name="last_price")
	public BigDecimal getLastPrice() {
		return this.lastPrice;
	}

	public void setLastPrice(BigDecimal lastPrice) {
		this.lastPrice = lastPrice;
	}


	@Column(name="last_price_delta")
	public BigDecimal getLastPriceDelta() {
		return this.lastPriceDelta;
	}

	public void setLastPriceDelta(BigDecimal lastPriceDelta) {
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
	@Temporal(TemporalType.TIME)	
	public Date getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}


	//bi-directional many-to-one association to Instrument
	@ManyToOne()
	@JoinColumn(name="instrument_id", nullable=false)
	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	@Override
	public String toString(){
		return String.format("Level1 data: date=%s, price=%s, volume=%s...", date, lastPrice, lastSize);
	}

}