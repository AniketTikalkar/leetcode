SELECT max(payout.trans_id) as SAMPLE_ID,count(payout.trans_id) as NUMBER_OF_TXN 
    FROM pp_access_views.dw_transaction payout inner join 
    pp_access_views.dw_transaction instrument on payout.actvty_id = instrument.actvty_id 
    WHERE payout.trans_crtd_date >= (current_date-60) and payout.trans_type = 'N' and payout.trans_local_curncy_amt > 0 
    and payout.trans_status = 'S' and instrument.trans_crtd_date >= (current_date-60) 
    and instrument.trans_type = 'A' and instrument.trans_local_curncy_amt < 0 
    and instrument.trans_status = 'S' and instrument.curncy_code = 'GBP'