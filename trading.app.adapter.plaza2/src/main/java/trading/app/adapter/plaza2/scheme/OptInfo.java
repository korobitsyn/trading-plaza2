package trading.app.adapter.plaza2.scheme;

public final class OptInfo
{


// ------------------------------------------
// Scheme "CustReplScheme"
// ------------------------------------------

    public static final class opt_rejected_orders
    {
        public static final int TABLE_INDEX = 0;
        
	public static final int MSG_SIZE = 416;
        private java.nio.ByteBuffer data;

        public opt_rejected_orders() {
            
        }

        public opt_rejected_orders(java.nio.ByteBuffer data) {
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

        
    
        public long get_order_id() {
            data.position(24);
            return data.getLong();
        }

        public void set_order_id(long val) {
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

        
    
        public String get_client_code() {
            data.position(36);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(36);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public java.util.Date get_moment() {
            data.position(44);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment(java.util.Date val) {
            data.position(44);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.util.Date get_moment_reject() {
            data.position(54);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_moment_reject(java.util.Date val) {
            data.position(54);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public int get_isin_id() {
            data.position(64);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(64);
            data.putInt(val);
        }

        
    
        public byte get_dir() {
            data.position(68);
            return data.get();
        }

        public void set_dir(byte val) {
            data.position(68);
            data.put(val);
        }

        
    
        public int get_amount() {
            data.position(72);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(72);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_price() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_price(java.math.BigDecimal val) {
            data.position(76);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_price_scale() {
            data.position(76);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_date_exp() {
            data.position(88);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_date_exp(java.util.Date val) {
            data.position(88);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public long get_id_ord1() {
            data.position(100);
            return data.getLong();
        }

        public void set_id_ord1(long val) {
            data.position(100);
            data.putLong(val);
        }

        
    
        public int get_ret_code() {
            data.position(108);
            return data.getInt();
        }

        public void set_ret_code(int val) {
            data.position(108);
            data.putInt(val);
        }

        
    
        public String get_ret_message() {
            data.position(112);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 255);
        }

        public void set_ret_message(String val) {
            data.position(112);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 255);
        }

        
    
        public String get_comment() {
            data.position(368);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_comment(String val) {
            data.position(368);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public String get_login_from() {
            data.position(389);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 20);
        }

        public void set_login_from(String val) {
            data.position(389);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 20);
        }

        
    
        public int get_ext_id() {
            data.position(412);
            return data.getInt();
        }

        public void set_ext_id(int val) {
            data.position(412);
            data.putInt(val);
        }

        
    


    }

    public static final class opt_intercl_info
    {
        public static final int TABLE_INDEX = 1;
        
	public static final int MSG_SIZE = 46;
        private java.nio.ByteBuffer data;

        public opt_intercl_info() {
            
        }

        public opt_intercl_info(java.nio.ByteBuffer data) {
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

        
    
        public int get_isin_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public String get_client_code() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public java.math.BigDecimal get_vm_intercl() {
            data.position(36);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_vm_intercl(java.math.BigDecimal val) {
            data.position(36);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_vm_intercl_scale() {
            data.position(36);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class opt_exp_orders
    {
        public static final int TABLE_INDEX = 2;
        
	public static final int MSG_SIZE = 68;
        private java.nio.ByteBuffer data;

        public opt_exp_orders() {
            
        }

        public opt_exp_orders(java.nio.ByteBuffer data) {
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

        
    
        public long get_exporder_id() {
            data.position(24);
            return data.getLong();
        }

        public void set_exporder_id(long val) {
            data.position(24);
            data.putLong(val);
        }

        
    
        public String get_client_code() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public int get_isin_id() {
            data.position(40);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(40);
            data.putInt(val);
        }

        
    
        public int get_amount() {
            data.position(44);
            return data.getInt();
        }

        public void set_amount(int val) {
            data.position(44);
            data.putInt(val);
        }

        
    
        public int get_sess_id() {
            data.position(48);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(48);
            data.putInt(val);
        }

        
    
        public java.util.Date get_date() {
            data.position(52);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_date(java.util.Date val) {
            data.position(52);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public int get_amount_apply() {
            data.position(64);
            return data.getInt();
        }

        public void set_amount_apply(int val) {
            data.position(64);
            data.putInt(val);
        }

        
    


    }

    public static final class opt_vcb
    {
        public static final int TABLE_INDEX = 3;
        
	public static final int MSG_SIZE = 204;
        private java.nio.ByteBuffer data;

        public opt_vcb() {
            
        }

        public opt_vcb(java.nio.ByteBuffer data) {
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

        
    
        public String get_name() {
            data.position(50);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 75);
        }

        public void set_name(String val) {
            data.position(50);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 75);
        }

        
    
        public String get_exec_type() {
            data.position(126);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 1);
        }

        public void set_exec_type(String val) {
            data.position(126);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 1);
        }

        
    
        public String get_curr() {
            data.position(128);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 3);
        }

        public void set_curr(String val) {
            data.position(128);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 3);
        }

        
    
        public java.math.BigDecimal get_exch_pay() {
            data.position(132);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_exch_pay(java.math.BigDecimal val) {
            data.position(132);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_exch_pay_scale() {
            data.position(132);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public byte get_exch_pay_scalped() {
            data.position(142);
            return data.get();
        }

        public void set_exch_pay_scalped(byte val) {
            data.position(142);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_clear_pay() {
            data.position(143);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_clear_pay(java.math.BigDecimal val) {
            data.position(143);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_clear_pay_scale() {
            data.position(143);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public byte get_clear_pay_scalped() {
            data.position(153);
            return data.get();
        }

        public void set_clear_pay_scalped(byte val) {
            data.position(153);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_sell_fee() {
            data.position(154);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_sell_fee(java.math.BigDecimal val) {
            data.position(154);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d7.3", val);
        }

        
        public byte get_sell_fee_scale() {
            data.position(154);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_buy_fee() {
            data.position(160);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_buy_fee(java.math.BigDecimal val) {
            data.position(160);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d7.3", val);
        }

        
        public byte get_buy_fee_scale() {
            data.position(160);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public String get_trade_scheme() {
            data.position(166);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 1);
        }

        public void set_trade_scheme(String val) {
            data.position(166);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 1);
        }

        
    
        public java.math.BigDecimal get_coeff_out() {
            data.position(168);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_coeff_out(java.math.BigDecimal val) {
            data.position(168);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d7.3", val);
        }

        
        public byte get_coeff_out_scale() {
            data.position(168);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public byte get_is_spec() {
            data.position(174);
            return data.get();
        }

        public void set_is_spec(byte val) {
            data.position(174);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_spec_spread() {
            data.position(175);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_spec_spread(java.math.BigDecimal val) {
            data.position(175);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_spec_spread_scale() {
            data.position(175);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_min_vol() {
            data.position(188);
            return data.getInt();
        }

        public void set_min_vol(int val) {
            data.position(188);
            data.putInt(val);
        }

        
    
        public String get_client_code() {
            data.position(192);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 7);
        }

        public void set_client_code(String val) {
            data.position(192);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 7);
        }

        
    
        public int get_rate_id() {
            data.position(200);
            return data.getInt();
        }

        public void set_rate_id(int val) {
            data.position(200);
            data.putInt(val);
        }

        
    


    }

    public static final class opt_sess_contents
    {
        public static final int TABLE_INDEX = 4;
        
	public static final int MSG_SIZE = 376;
        private java.nio.ByteBuffer data;

        public opt_sess_contents() {
            
        }

        public opt_sess_contents(java.nio.ByteBuffer data) {
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

        
    
        public int get_sess_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public int get_isin_id() {
            data.position(28);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(28);
            data.putInt(val);
        }

        
    
        public String get_isin() {
            data.position(32);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(32);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_short_isin() {
            data.position(58);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_short_isin(String val) {
            data.position(58);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public String get_name() {
            data.position(84);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 75);
        }

        public void set_name(String val) {
            data.position(84);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 75);
        }

        
    
        public String get_code_vcb() {
            data.position(160);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_code_vcb(String val) {
            data.position(160);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public int get_fut_isin_id() {
            data.position(188);
            return data.getInt();
        }

        public void set_fut_isin_id(int val) {
            data.position(188);
            data.putInt(val);
        }

        
    
        public byte get_is_limited() {
            data.position(192);
            return data.get();
        }

        public void set_is_limited(byte val) {
            data.position(192);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_limit_up() {
            data.position(193);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_limit_up(java.math.BigDecimal val) {
            data.position(193);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_limit_up_scale() {
            data.position(193);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_limit_down() {
            data.position(204);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_limit_down(java.math.BigDecimal val) {
            data.position(204);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_limit_down_scale() {
            data.position(204);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_old_kotir() {
            data.position(215);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_old_kotir(java.math.BigDecimal val) {
            data.position(215);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_old_kotir_scale() {
            data.position(215);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_bgo_c() {
            data.position(226);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_bgo_c(java.math.BigDecimal val) {
            data.position(226);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_bgo_c_scale() {
            data.position(226);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_bgo_nc() {
            data.position(236);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_bgo_nc(java.math.BigDecimal val) {
            data.position(236);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_bgo_nc_scale() {
            data.position(236);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public byte get_europe() {
            data.position(246);
            return data.get();
        }

        public void set_europe(byte val) {
            data.position(246);
            data.put(val);
        }

        
    
        public byte get_put() {
            data.position(247);
            return data.get();
        }

        public void set_put(byte val) {
            data.position(247);
            data.put(val);
        }

        
    
        public java.math.BigDecimal get_strike() {
            data.position(248);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_strike(java.math.BigDecimal val) {
            data.position(248);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_strike_scale() {
            data.position(248);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_roundto() {
            data.position(260);
            return data.getInt();
        }

        public void set_roundto(int val) {
            data.position(260);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_min_step() {
            data.position(264);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_min_step(java.math.BigDecimal val) {
            data.position(264);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_min_step_scale() {
            data.position(264);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_lot_volume() {
            data.position(276);
            return data.getInt();
        }

        public void set_lot_volume(int val) {
            data.position(276);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_step_price() {
            data.position(280);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_step_price(java.math.BigDecimal val) {
            data.position(280);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_step_price_scale() {
            data.position(280);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.util.Date get_d_pg() {
            data.position(292);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_d_pg(java.util.Date val) {
            data.position(292);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.util.Date get_d_exec_beg() {
            data.position(302);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_d_exec_beg(java.util.Date val) {
            data.position(302);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.util.Date get_d_exec_end() {
            data.position(312);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_d_exec_end(java.util.Date val) {
            data.position(312);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public int get_signs() {
            data.position(324);
            return data.getInt();
        }

        public void set_signs(int val) {
            data.position(324);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_last_cl_quote() {
            data.position(328);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_last_cl_quote(java.math.BigDecimal val) {
            data.position(328);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_last_cl_quote_scale() {
            data.position(328);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_bgo_buy() {
            data.position(339);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_bgo_buy(java.math.BigDecimal val) {
            data.position(339);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_bgo_buy_scale() {
            data.position(339);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public int get_base_isin_id() {
            data.position(352);
            return data.getInt();
        }

        public void set_base_isin_id(int val) {
            data.position(352);
            data.putInt(val);
        }

        
    
        public java.util.Date get_d_start() {
            data.position(356);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_d_start(java.util.Date val) {
            data.position(356);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public java.math.BigDecimal get_exch_pay() {
            data.position(366);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_exch_pay(java.math.BigDecimal val) {
            data.position(366);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.2", val);
        }

        
        public byte get_exch_pay_scale() {
            data.position(366);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    


    }

    public static final class opt_sess_settl
    {
        public static final int TABLE_INDEX = 5;
        
	public static final int MSG_SIZE = 90;
        private java.nio.ByteBuffer data;

        public opt_sess_settl() {
            
        }

        public opt_sess_settl(java.nio.ByteBuffer data) {
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

        
    
        public int get_sess_id() {
            data.position(24);
            return data.getInt();
        }

        public void set_sess_id(int val) {
            data.position(24);
            data.putInt(val);
        }

        
    
        public java.util.Date get_date_clr() {
            data.position(28);
            return ru.micexrts.cgate.P2TypeParser.parseTimeAsDate(data);
        }

        public void set_date_clr(java.util.Date val) {
            data.position(28);
            ru.micexrts.cgate.P2TypeComposer.composeDateAsTime(data, val);
        }

        
    
        public String get_isin() {
            data.position(38);
            return ru.micexrts.cgate.P2TypeParser.parseCXX(data, 25);
        }

        public void set_isin(String val) {
            data.position(38);
            ru.micexrts.cgate.P2TypeComposer.composeCXX(data, val, 25);
        }

        
    
        public int get_isin_id() {
            data.position(64);
            return data.getInt();
        }

        public void set_isin_id(int val) {
            data.position(64);
            data.putInt(val);
        }

        
    
        public java.math.BigDecimal get_volat() {
            data.position(68);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_volat(java.math.BigDecimal val) {
            data.position(68);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_volat_scale() {
            data.position(68);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
        }
        
    
        public java.math.BigDecimal get_theor_price() {
            data.position(79);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsBigDecimal(data);
        }

        public void set_theor_price(java.math.BigDecimal val) {
            data.position(79);
            ru.micexrts.cgate.P2TypeComposer.composeBigDecimalAsBCD(data, "d16.5", val);
        }

        
        public byte get_theor_price_scale() {
            data.position(79);
            return ru.micexrts.cgate.P2TypeParser.parseBCDAsScale(data);
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

