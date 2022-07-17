INSERT INTO market (market_type, id, status, name) VALUES (1, '3way', 1, '3way');
INSERT INTO market (market_type, id, status, name) VALUES (1, '2way', 1, '2way');
INSERT INTO outcome (id, name, status, outcome_type) VALUES ('3way-1', '1', 1, 1);
INSERT INTO outcome (id, name, status, outcome_type) VALUES ('3way-2', '2', 1, 1);
INSERT INTO outcome (id, name, status, outcome_type) VALUES ('3way-X', 'X', 0, 1);
INSERT INTO market_outcomes VALUES ('3way', '3way-1');
INSERT INTO market_outcomes VALUES ('3way', '3way-2');
INSERT INTO market_outcomes VALUES ('3way', '3way-X');
INSERT INTO outcome (id, name, status, outcome_type) VALUES ('2way-1', '1', 1, 1);
INSERT INTO outcome (id, name, status, outcome_type) VALUES ('2way-2', '2', 1, 1);
INSERT INTO market_outcomes VALUES ('2way', '2way-1');
INSERT INTO market_outcomes VALUES ('2way', '2way-2');
INSERT INTO market (market_type, id, market_id, status) VALUES (2, '1-1', '3way', 1);
INSERT INTO market (market_type, id, market_id, status) VALUES (2, '2-1', '3way', 1);
INSERT INTO event (id, name, starts_at, status) VALUES('1', 'Real Madrid - Barcelona', '2032-05-01T20:00:00', 1);
INSERT INTO event (id, name, starts_at, status) VALUES('2', 'Bosnia and Herzegovina - Nigeria', '2014-06-02T20:00:00', 1);
INSERT INTO event_markets (event_id, markets_id) VALUES ('1','1-1');
INSERT INTO event_markets (event_id, markets_id) VALUES ('2','2-1');
INSERT INTO outcome (id, outcome_id, outcome_type, odd, status) VALUES ('1-1-1', '3way-1', 2, 1.5513, 1);
INSERT INTO outcome (id, outcome_id, outcome_type, odd, status) VALUES ('1-1-2', '3way-2', 2, 2.1, 0);
INSERT INTO market_outcomes (base_market_id, outcomes_id) VALUES ('1-1', '1-1-1');
INSERT INTO market_outcomes (base_market_id, outcomes_id) VALUES ('1-1', '1-1-2');
INSERT INTO outcome (id, outcome_id, outcome_type, odd, status) VALUES ('2-1-1', '3way-1', 2, 1.5513, 1);
INSERT INTO outcome (id, outcome_id, outcome_type, odd, status) VALUES ('2-1-2', '3way-2', 2, 2.1, 0);
INSERT INTO market_outcomes (base_market_id, outcomes_id) VALUES ('2-1', '2-1-1');
INSERT INTO market_outcomes (base_market_id, outcomes_id) VALUES ('2-1', '2-1-2');
