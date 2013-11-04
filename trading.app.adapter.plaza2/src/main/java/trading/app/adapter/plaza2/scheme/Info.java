package trading.app.adapter.plaza2.scheme;
public final class Info
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class base_contracts_params
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 128;
        private java.nio.ByteBuffer data;

        public base_contracts_params() {
            
        }

        public base_contracts_params(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public String get_code_vcb() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_code_mcs() {
            data.position(50);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_mcs(String val) {
            data.position(50);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public byte get_volat_num() {
            data.position(76);
            return data.get();
        }

        public void set_volat_num(byte val) {
            data.position(76);
            data.put(val);
        }

        
    
        public byte get_points_num() {
            data.position(77);
            return data.get();
        }

        public void set_points_num(byte val) {
            data.position(77);
            data.put(val);
        }

        
    
        public double get_subrisk_step() {
            data.position(80);
            return data.getDouble();
        }

        public void set_subrisk_step(double val) {
            data.position(80);
            data.putDouble(val);
        }

        
    
        public byte get_is_percent() {
            data.position(88);
            return data.get();
        }

        public void set_is_percent(byte val) {
            data.position(88);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_percent_rate() {
            data.position(89);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_percent_rate(java.math.BigDecimal val) {
            data.position(89);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_percent_rate_scale() {
            data.position(89);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_currency_volat() {
            data.position(100);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_currency_volat(java.math.BigDecimal val) {
            data.position(100);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_currency_volat_scale() {
            data.position(100);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public byte get_is_usd() {
            data.position(111);
            return data.get();
        }

        public void set_is_usd(byte val) {
            data.position(111);
            data.put(val);
        }

        
    
        public double get_usd_rate_curv_radius() {
            data.position(112);
            return data.getDouble();
        }

        public void set_usd_rate_curv_radius(double val) {
            data.position(112);
            data.putDouble(val);
        }

        
    
        public double get_somc() {
            data.position(120);
            return data.getDouble();
        }

        public void set_somc(double val) {
            data.position(120);
            data.putDouble(val);
        }

        
    


    }

    public static final class futures_params
    {
        public static final int TABLE_INDEX = 1;
        
	public static final int MSG_SIZE = 164;
        private java.nio.ByteBuffer data;

        public futures_params() {
            
        }

        public futures_params(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public String get_isin() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public int get_isin_id() {
            data.position(52);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(52);
            data.putInt(val);
        }

        
    
        public String get_code_vcb() {
            data.position(56);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(56);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public double get_limit() {
            data.position(84);
            return data.getDouble();
        }

        public void set_limit(double val) {
            data.position(84);
            data.putDouble(val);
        }

        
    
        public java.math.BigDecimal get_settl_price() {
            data.position(92);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_settl_price(java.math.BigDecimal val) {
            data.position(92);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_settl_price_scale() {
            data.position(92);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public byte get_spread_aspect() {
            data.position(103);
            return data.get();
        }

        public void set_spread_aspect(byte val) {
            data.position(103);
            data.put(val);
        }

        
    
        public byte get_subrisk() {
            data.position(104);
            return data.get();
        }

        public void set_subrisk(byte val) {
            data.position(104);
            data.put(val);
        }

        
    
        public double get_step_price() {
            data.position(108);
            return data.getDouble();
        }

        public void set_step_price(double val) {
            data.position(108);
            data.putDouble(val);
        }

        
    
        public java.math.BigDecimal get_base_go() {
            data.position(116);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_base_go(java.math.BigDecimal val) {
            data.position(116);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_base_go_scale() {
            data.position(116);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_exp_date() {
            data.position(132);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_exp_date(java.util.Date val) {
            data.position(132);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public byte get_spot_signs() {
            data.position(142);
            return data.get();
        }

        public void set_spot_signs(byte val) {
            data.position(142);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_settl_price_real() {
            data.position(143);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_settl_price_real(java.math.BigDecimal val) {
            data.position(143);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_settl_price_real_scale() {
            data.position(143);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public double get_min_step() {
            data.position(156);
            return data.getDouble();
        }

        public void set_min_step(double val) {
            data.position(156);
            data.putDouble(val);
        }

        
    


    }

    public static final class virtual_futures_params
    {
        public static final int TABLE_INDEX = 2;
        
	public static final int MSG_SIZE = 164;
        private java.nio.ByteBuffer data;

        public virtual_futures_params() {
            
        }

        public virtual_futures_params(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public String get_isin() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_isin_base() {
            data.position(50);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin_base(String val) {
            data.position(50);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public byte get_is_net_positive() {
            data.position(76);
            return data.get();
        }

        public void set_is_net_positive(byte val) {
            data.position(76);
            data.put(val);
        }

        
    
        public double get_volat_range() {
            data.position(80);
            return data.getDouble();
        }

        public void set_volat_range(double val) {
            data.position(80);
            data.putDouble(val);
        }

        
    
        public double get_t_squared() {
            data.position(88);
            return data.getDouble();
        }

        public void set_t_squared(double val) {
            data.position(88);
            data.putDouble(val);
        }

        
    
        public double get_max_addrisk() {
            data.position(96);
            return data.getDouble();
        }

        public void set_max_addrisk(double val) {
            data.position(96);
            data.putDouble(val);
        }

        
    
        public double get_a() {
            data.position(104);
            return data.getDouble();
        }

        public void set_a(double val) {
            data.position(104);
            data.putDouble(val);
        }

        
    
        public double get_b() {
            data.position(112);
            return data.getDouble();
        }

        public void set_b(double val) {
            data.position(112);
            data.putDouble(val);
        }

        
    
        public double get_c() {
            data.position(120);
            return data.getDouble();
        }

        public void set_c(double val) {
            data.position(120);
            data.putDouble(val);
        }

        
    
        public double get_d() {
            data.position(128);
            return data.getDouble();
        }

        public void set_d(double val) {
            data.position(128);
            data.putDouble(val);
        }

        
    
        public double get_e() {
            data.position(136);
            return data.getDouble();
        }

        public void set_e(double val) {
            data.position(136);
            data.putDouble(val);
        }

        
    
        public double get_s() {
            data.position(144);
            return data.getDouble();
        }

        public void set_s(double val) {
            data.position(144);
            data.putDouble(val);
        }

        
    
        public java.util.Date get_exp_date() {
            data.position(152);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_exp_date(java.util.Date val) {
            data.position(152);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public byte get_fut_type() {
            data.position(162);
            return data.get();
        }

        public void set_fut_type(byte val) {
            data.position(162);
            data.put(val);
        }

        
    
        public byte get_use_null_volat() {
            data.position(163);
            return data.get();
        }

        public void set_use_null_volat(byte val) {
            data.position(163);
            data.put(val);
        }

        
    


    }

    public static final class options_params
    {
        public static final int TABLE_INDEX = 3;
        
	public static final int MSG_SIZE = 150;
        private java.nio.ByteBuffer data;

        public options_params() {
            
        }

        public options_params(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public String get_isin() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public int get_isin_id() {
            data.position(52);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(52);
            data.putInt(val);
        }

        
    
        public String get_isin_base() {
            data.position(56);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin_base(String val) {
            data.position(56);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public java.math.BigDecimal get_strike() {
            data.position(82);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_strike(java.math.BigDecimal val) {
            data.position(82);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_strike_scale() {
            data.position(82);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public byte get_opt_type() {
            data.position(93);
            return data.get();
        }

        public void set_opt_type(byte val) {
            data.position(93);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_settl_price() {
            data.position(94);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_settl_price(java.math.BigDecimal val) {
            data.position(94);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_settl_price_scale() {
            data.position(94);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_base_go_sell() {
            data.position(105);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_base_go_sell(java.math.BigDecimal val) {
            data.position(105);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_base_go_sell_scale() {
            data.position(105);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_synth_base_go() {
            data.position(120);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_synth_base_go(java.math.BigDecimal val) {
            data.position(120);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_synth_base_go_scale() {
            data.position(120);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_base_go_buy() {
            data.position(135);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_base_go_buy(java.math.BigDecimal val) {
            data.position(135);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d26.2", val);
        }

        
        public byte get_base_go_buy_scale() {
            data.position(135);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class broker_params
    {
        public static final int TABLE_INDEX = 4;
        
	public static final int MSG_SIZE = 68;
        private java.nio.ByteBuffer data;

        public broker_params() {
            
        }

        public broker_params(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public String get_broker_code() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_broker_code(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public String get_code_vcb() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public int get_limit_spot_sell() {
            data.position(60);
            return data.getInt();
        }

        public void set_limit_spot_sell(int val) {
            data.position(60);
            data.putInt(val);
        }

        
    
        public int get_used_limit_spot_sell() {
            data.position(64);
            return data.getInt();
        }

        public void set_used_limit_spot_sell(int val) {
            data.position(64);
            data.putInt(val);
        }

        
    


    }

    public static final class client_params
    {
        public static final int TABLE_INDEX = 5;
        
	public static final int MSG_SIZE = 80;
        private java.nio.ByteBuffer data;

        public client_params() {
            
        }

        public client_params(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public String get_client_code() {
            data.position(24);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(24);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public String get_code_vcb() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public java.math.BigDecimal get_coeff_go() {
            data.position(58);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_coeff_go(java.math.BigDecimal val) {
            data.position(58);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_coeff_go_scale() {
            data.position(58);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_limit_spot_sell() {
            data.position(72);
            return data.getInt();
        }

        public void set_limit_spot_sell(int val) {
            data.position(72);
            data.putInt(val);
        }

        
    
        public int get_used_limit_spot_sell() {
            data.position(76);
            return data.getInt();
        }

        public void set_used_limit_spot_sell(int val) {
            data.position(76);
            data.putInt(val);
        }

        
    


    }

    public static final class sys_events
    {
        public static final int TABLE_INDEX = 6;
        
	public static final int MSG_SIZE = 105;
        private java.nio.ByteBuffer data;

        public sys_events() {
            
        }

        public sys_events(java.nio.ByteBuffer data) {
            this.data = data;
        }

        public java.nio.ByteBuffer getData() {
            return data;
        }

        public void setData(java.nio.ByteBuffer data) {
            this.data = data;
        }

    
        public long get_replID() {
            data.position(0);
            return data.getLong();
        }

        public void set_replID(long val) {
            data.position(0);
            data.putLong(val);
        }

        
    
        public long get_replRev() {
            data.position(8);
            return data.getLong();
        }

        public void set_replRev(long val) {
            data.position(8);
            data.putLong(val);
        }

        
    
        public long get_replAct() {
            data.position(16);
            return data.getLong();
        }

        public void set_replAct(long val) {
            data.position(16);
            data.putLong(val);
        }

        
    
        public long get_event_id() {
            data.position(24);
            return data.getLong();
        }

        public void set_event_id(long val) {
            data.position(24);
            data.putLong(val);
        }

        
    
        public int get_sess_id() {
            data.position(32);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(32);
            data.putInt(val);
        }

        
    
        public int get_event_type() {
            data.position(36);
            return data.getInt();
        }

        public void set_event_type(int val) {
            data.position(36);
            data.putInt(val);
        }

        
    
        public String get_message() {
            data.position(40);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 64);
        }

        public void set_message(String val) {
            data.position(40);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 64);
        }

        
    


    }

}

