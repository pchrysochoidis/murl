-- import.sql file used for unit tests

-- Add Cylon as an organization
insert into profiles_organization (id, `name`, domain_name, favicon, css, logo, enable) values (1, 'Cylon Controls', 'localhost', 'myfavicon', 'mycss', 'mylogo', 1);
insert into profiles_organization (id, `name`, domain_name, parent_organization_id, enable) values (2, 'Philips', 'philips', 1, 1);
insert into profiles_organization (id, `name`, domain_name, parent_organization_id, favicon, css, enable) values (3, 'OCS', 'ocs', 1, 'my own favicon', 'my own css', 1);

-- Add login pages
insert into profiles_loginpage (id, organization_id, language_code, country_code, login_title, text_fields) values (1, 1, 'NONE', 'NONE', 'Welcome to the cylonaem login', '{"text_fields": [{"title" : "News", "text" : "Read our latest news on new features, product releases and more.", "link": "http://www.cylon.com/ie/news/"}]}');
insert into profiles_loginpage (id, organization_id, language_code, country_code, login_title) values (2, 3, 'NONE', 'NONE', 'Welcome to the OCS Manager');
insert into profiles_loginpage (id, organization_id, language_code, country_code, login_title) values (3, 3, 'DE', 'NONE', 'Welcome to the German OCS Manager');
insert into profiles_loginpage (id, organization_id, language_code, country_code, login_title) values (4, 3, 'EN', 'US', 'Welcome to the US OCS Manager');
insert into profiles_loginpage (id, organization_id, language_code, country_code, login_title) values (5, 1, 'EN', 'NONE', 'Welcome to the English cylonaem login');
insert into profiles_loginpage (id, organization_id, language_code, country_code, login_title) values (6, 1, 'EN', 'US', 'Welcome to the US cylonaem login');

-- Add home pages
insert into profiles_homepage (id, organization_id, language_code, country_code, home_page_title, home_page_links) values (1, 1, 'NONE', 'NONE', 'Main Menu', '{"home_page_links" : [{"title": "Analysis", "target": 1}]}');
insert into profiles_homepage (id, organization_id, language_code, country_code, home_page_title) values (2, 3, 'NONE', 'NONE', 'OCS Menu');
insert into profiles_homepage (id, organization_id, language_code, country_code, home_page_title) values (3, 3, 'DE', 'NONE', 'German Menu');
insert into profiles_homepage (id, organization_id, language_code, country_code, home_page_title) values (4, 3, 'EN', 'US', 'US Menu');
-- Add media settings
insert into profiles_mediasettings (id, organization_id, language_code, country_code, website) values (1, 1, 'NONE', 'NONE', 'cylonaem.com');
insert into profiles_mediasettings (id, organization_id, language_code, country_code, website) values (2, 3, 'NONE', 'NONE', 'www.ocs.ie');
insert into profiles_mediasettings (id, organization_id, language_code, country_code, website) values (3, 3, 'DE', 'NONE', 'www.ocs.de');
insert into profiles_mediasettings (id, organization_id, language_code, country_code, website) values (4, 3, 'EN', 'US', 'www.ocs.com');

-- add delegate
insert into  profiles_organization_delegates values (1,2);
-- Add a default user (of Philips)
insert into auth_user (id, username, password, is_active, is_staff, is_superuser, primary_organization_id, session_limit,two_factor_auth, first_name, last_name, last_login, date_joined ) values (1,'philip','p',1,1,1,1,1,0,'philip','peelo','2014-10-10', '2014-10-10');
insert into auth_user (id, username, password, is_active, is_staff, is_superuser, primary_organization_id, session_limit,two_factor_auth, first_name, last_name, last_login, date_joined ) values (2,'xaren','p',1,1,1,2,1,0,'xaren','peelo','2014-10-10', '2014-10-10');

-- add role
INSERT INTO auth_role (`name`) VALUES ('Role');

--add role to user
INSERT INTO auth_user_role values (1,1);

-- Add a dca storage end point
insert into dca_storage_end_point values (1, 'test','test');

-- Add a dca
insert into dca values(1,5,'1.0.1','2014-10-11','test',12,1,1);

-- Add energy unit
insert into energy_unit(long_name,short_name,unit_position) values('unit1','u1',0);
insert into energy_unit(long_name,short_name,unit_position) values('unit2','u2',1);

-- Add energy unit conversion
INSERT INTO energy_unit_conversion (add_tp, multiply_by, multiply_by_factor_of_interval, unit_from_id, unit_to_id) VALUES ('10', '5', '2', '1', '2');

-- Add an energy utility
insert into energy_utility values (1, 'utility1');

-- Add a datalog type
insert into ENERGY_DATALOG_TYPE values(1,'type',1,1);

-- Add a dca connection
insert into dca_connection (id, host, password, port, timezone, username, dca_config_id, dtype) values (1,'localhost','p',8080,'Europe/Dublin','eugene',1,'UNITRON');

-- Add an energy_scaling range
INSERT into energy_scaling_range (id, fromlower, fromupper, name, tolower,toupper) values (1,2.0,3.0,'cylon',2.0,3.0);

-- Add normalization factor
insert into energy_normalization_factor (id, default_cdd_setpoint, default_hdd_setpoint, gross_internal_area, name, net_internal_area, typical_occupancy, cdd_unit_id, gross_internal_unit_id, hdd_unit_id, net_internal_unit_id) values (1, 12,12,12,'currency',12,12,1,1,1,1);

-- add building
insert into energy_building (id, latitude, longitute, name, timezone, main_meter_id, normalization_id, primary_organization_id) values  (1,50.65,45.23, 'Library','Europe/Dublin',null,1,1);

-- add energy datalog
insert into energy_datalog  (id, building_id, bms_id, display_name, "interval", is_virtual, manual_entry_allowed, max_lateness, meter_type, name, scalingrange_id, simple_scaling_factor, datalog_type_id, dca_id, normalization_id) values (1,1,1,'cylon',1,1,1,10,null,'cylon',1,0.0,1,1,null);

-- update main meter
update energy_building set main_meter_id = 1 where id = 1;

-- add energy tree
INSERT INTO energy_tree (`id`, `name`, `organization_id`) VALUES ('1', 'My first tree', '1');

-- add energy tree folders
INSERT INTO energy_folder (`id`, `energy_tree_id`, `name`) VALUES ('1', '1', 'My first root folder');
INSERT INTO energy_folder (`id`, `energy_tree_id`, `name`, `parent_folder_id`) VALUES ('2', '1', 'Some node', '1');

insert into complex_normalization (id, name, rate, symbol, normalization_id, unit_id, utility_id) values (1, 'Complex Factor', 12.5, '$', 1, 1, 1);

insert into report_parameters(id, json_parameters, user_id) values (1, '{"one": "two","key": "value"}', 2);