
    create table addresses (
       id_addresses int8 generated by default as identity,
        function_address_type varchar(255),
        is_customer boolean,
        is_default_address boolean,
        is_vendor boolean,
        version varchar(255),
        business_object_id_business_object int8,
        primary key (id_addresses)
    );

    create table addresses_overviews (
       id_addresses_overviews int8 generated by default as identity,
        address_type varchar(255),
        city_number varchar(255),
        country_number varchar(255),
        district varchar(255),
        effective_date varchar(255),
        expiry_date varchar(255),
        postal_code varchar(255),
        state_number varchar(255),
        status varchar(255),
        street_name1 varchar(255),
        street_name2 varchar(255),
        street_number varchar(255),
        version varchar(255),
        addresses_id_addresses int8,
        primary key (id_addresses_overviews)
    );

    create table bill_to_parties (
       id_bill_to_parties int8 generated by default as identity,
        btppartner_number varchar(255),
        city_number varchar(255),
        effective_date varchar(255),
        expiry_date varchar(255),
        is_auto_btp boolean,
        is_default boolean,
        version varchar(255),
        partner_roles_id_partner_roles int8,
        primary key (id_bill_to_parties)
    );

    create table boycott_statuses (
       id_boycott_statuses int8 generated by default as identity,
        effective_date varchar(255),
        expiry_date varchar(255),
        status varchar(255),
        version varchar(255),
        business_object_id_business_object int8,
        primary key (id_boycott_statuses)
    );

    create table bpma (
       id_business_partner int8 generated by default as identity,
        business_object_id_business_object int8,
        process_data_id_process_data int8,
        primary key (id_business_partner)
    );

    create table bpma_addresses_request (
       id_bpma_addresses_request int8 generated by default as identity,
        address varchar(255),
        busu_city_id varchar(255),
        busu_city_name varchar(255),
        busu_state_id varchar(255),
        complement varchar(255),
        district varchar(255),
        globebpnumber varchar(255),
        globe_expiry_date varchar(255),
        globe_sfc varchar(255),
        globe_status_description varchar(255),
        main_facility boolean,
        number varchar(255),
        source varchar(255),
        zip_code varchar(255),
        primary key (id_bpma_addresses_request)
    );

    create table bpma_communication_details (
       id_bpma_communication_details int8 generated by default as identity,
        communication_type varchar(255),
        communication_value varchar(255),
        is_preferred boolean,
        version varchar(255),
        primary key (id_bpma_communication_details)
    );

    create table bpma_event_hub (
       id_bpma_event_hub int8 generated by default as identity,
        business_object bytea,
        process_data bytea,
        primary key (id_bpma_event_hub)
    );

    create table bpma_request (
       id_bpma_request int8 generated by default as identity,
        business_partner_id varchar(255),
        company_name varchar(255),
        facility_list bytea,
        globe_status_description varchar(255),
        person_type varchar(255),
        process_data bytea,
        state_registration varchar(255),
        state_registration_exempt boolean,
        status int4,
        tax_id varchar(255),
        vendor_business_list bytea,
        primary key (id_bpma_request)
    );

    create table bpma_service_bus (
       id_bpma_service_bus int8 generated by default as identity,
        business_object bytea,
        process_data bytea,
        primary key (id_bpma_service_bus)
    );

    create table business_object (
       id_business_object int8 generated by default as identity,
        alias varchar(255),
        cmd_id varchar(255),
        code varchar(255),
        is_equipment_customer boolean,
        iskycchecked boolean,
        is_suspended boolean,
        is_tax_free_zone_address boolean,
        main_email_address varchar(255),
        main_fax_no varchar(255),
        main_telephone_no varchar(255),
        partner_short_name varchar(255),
        remark varchar(255),
        version varchar(255),
        primary key (id_business_object)
    );

    create table city (
       id_city int8 generated by default as identity,
        city_business_object_id_city_business_object int8,
        process_data_id_process_data int8,
        primary key (id_city)
    );

    create table city_business_object (
       id_city_business_object int8 generated by default as identity,
        city_codebr varchar(255),
        code varchar(255),
        country varchar(255),
        state varchar(255),
        valid_from varchar(255),
        valid_to varchar(255),
        version varchar(255),
        primary key (id_city_business_object)
    );

    create table city_compass_code (
       id_city_compass_code int8 generated by default as identity,
        code varchar(255),
        effective_from varchar(255),
        effective_to varchar(255),
        version varchar(255),
        city_business_object_id_city_business_object int8,
        primary key (id_city_compass_code)
    );

    create table city_location (
       id_city_location int8 generated by default as identity,
        code varchar(255),
        effective_from varchar(255),
        effective_to varchar(255),
        name varchar(255),
        version varchar(255),
        city_business_object_id_city_business_object int8,
        primary key (id_city_location)
    );

    create table city_naming (
       id_city_naming int8 generated by default as identity,
        effective_from varchar(255),
        effective_to varchar(255),
        name varchar(255),
        version varchar(255),
        city_business_object_id_city_business_object int8,
        primary key (id_city_naming)
    );

    create table city_postal_code_range (
       id_city_postal_code_range int8 generated by default as identity,
        effective_from varchar(255),
        effective_to varchar(255),
        from_code varchar(255),
        name varchar(255),
        version varchar(255),
        city_business_object_id_city_business_object int8,
        primary key (id_city_postal_code_range)
    );

    create table city_us_code (
       id_city_cs_code int8 generated by default as identity,
        code varchar(255),
        effective_from varchar(255),
        effective_to varchar(255),
        version varchar(255),
        city_business_object_id_city_business_object int8,
        primary key (id_city_cs_code)
    );

    create table communication_details (
       id_communication_details int8 generated by default as identity,
        communication_type varchar(255),
        communication_value varchar(255),
        is_preferred boolean,
        version varchar(255),
        contacts_id_contacts int8,
        primary key (id_communication_details)
    );

    create table communication_preferences (
       id_communication_preferences int8 generated by default as identity,
        communication_number varchar(255),
        communication_type varchar(255),
        function_activity_type varchar(255),
        is_preferred boolean,
        version varchar(255),
        partner_roles_id_partner_roles int8,
        primary key (id_communication_preferences)
    );

    create table contacts (
       id_contacts int8 generated by default as identity,
        business_function varchar(255),
        effective_date varchar(255),
        expiry_date varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        person_title varchar(255),
        person_type varchar(255),
        remark varchar(255),
        version varchar(255),
        addresses_id_addresses int8,
        primary key (id_contacts)
    );

    create table ecommerce_channels (
       id_ecommerce_channels int8 generated by default as identity,
        channel_code varchar(255),
        channel_name varchar(255),
        fi_account_number varchar(255),
        is_preferred varchar(255),
        territory_number varchar(255),
        version varchar(255),
        business_object_id_business_object int8,
        primary key (id_ecommerce_channels)
    );

    create table ecommerce_products (
       id_ecommerce_channels int8 generated by default as identity,
        product_name varchar(255),
        version varchar(255),
        ecommerce_channels_id_ecommerce_channels int8,
        primary key (id_ecommerce_channels)
    );

    create table facility (
       id_facility int8 generated by default as identity,
        facility_business_object_id_facility_business_object int8,
        process_data_id_process_data int8,
        primary key (id_facility)
    );

    create table facility_access (
       id_facility_access int8 generated by default as identity,
        access_mode varchar(255),
        version varchar(255),
        facility_details_id_facility_details int8,
        primary key (id_facility_access)
    );

    create table facility_business_object (
       id_facility_business_object int8 generated by default as identity,
        code varchar(255),
        customer_facility boolean,
        version varchar(255),
        facility_facility_details_id_facility_details int8,
        primary key (id_facility_business_object)
    );

    create table facility_chronology (
       id_facility_chronology int8 generated by default as identity,
        effective_from varchar(255),
        effective_to varchar(255),
        version varchar(255),
        facility_business_object_id_facility_business_object int8,
        facility_log_hierarchy_id_facility_log_hierarchy int8,
        facility_naming_id_facility_naming int8,
        facility_partner_id_facility_partner int8,
        primary key (id_facility_chronology)
    );

    create table facility_compass_code (
       id_facility_compass_code int8 generated by default as identity,
        facility_business_object_id_facility_business_object int8,
        primary key (id_facility_compass_code)
    );

    create table facility_cs_code (
       id_facility_cs_code int8 generated by default as identity,
        facility_business_object_id_facility_business_object int8,
        primary key (id_facility_cs_code)
    );

    create table facility_details (
       id_facility_details int8 generated by default as identity,
        primary key (id_facility_details)
    );

    create table facility_ext_ref_code_type (
       id_facility_ext_ref_code_type int8 generated by default as identity,
        facility_business_object_id_facility_business_object int8,
        primary key (id_facility_ext_ref_code_type)
    );

    create table facility_function (
       id_facility_function int8 generated by default as identity,
        facility_function_type varchar(255),
        facility_details_id_facility_details int8,
        primary key (id_facility_function)
    );

    create table facility_hour (
       id_facility_hour int8 generated by default as identity,
        facility_details_id_facility_details int8,
        primary key (id_facility_hour)
    );

    create table facility_log_hierarchy (
       id_facility_log_hierarchy int8 generated by default as identity,
        parent varchar(255),
        primary key (id_facility_log_hierarchy)
    );

    create table facility_naming (
       id_facility_naming int8 generated by default as identity,
        code varchar(255),
        name varchar(255),
        primary key (id_facility_naming)
    );

    create table facility_partner (
       id_facility_partner int8 generated by default as identity,
        partner_code varchar(255),
        partner_number varchar(255),
        primary key (id_facility_partner)
    );

    create table facility_status (
       id_facility_status int8 generated by default as identity,
        effective_from varchar(255),
        effective_to varchar(255),
        status varchar(255),
        version varchar(255),
        facility_business_object_id_facility_business_object int8,
        primary key (id_facility_status)
    );

    create table fi_accounts (
       id_fi_accounts int8 generated by default as identity,
        effective_date varchar(255),
        expiry_date varchar(255),
        fi_account_number varchar(255),
        is_non_globe varchar(255),
        partner_role varchar(255),
        territory_number varchar(255),
        version varchar(255),
        business_object_id_business_object int8,
        primary key (id_fi_accounts)
    );

    create table formatted_address (
       id_formatted_address int8 generated by default as identity,
        formatted_address varchar(255),
        addresses_id_addresses int8,
        primary key (id_formatted_address)
    );

    create table location (
       id_location int8 generated by default as identity,
        business_object_id_location_business_object int8,
        process_data_id_process_data int8,
        primary key (id_location)
    );

    create table location_business_object (
       id_location_business_object int8 generated by default as identity,
        code varchar(255),
        country varchar(255),
        is_port boolean,
        state varchar(255),
        valid_from varchar(255),
        valid_to varchar(255),
        version varchar(255),
        location_details_id_location_details int8,
        primary key (id_location_business_object)
    );

    create table location_cs_code (
       id_location_cs_code int8 generated by default as identity,
        ecos_port_code varchar(255),
        effective_from varchar(255),
        effective_to varchar(255),
        version varchar(255),
        location_business_object_id_location_business_object int8,
        primary key (id_location_cs_code)
    );

    create table location_details (
       id_location_details int8 generated by default as identity,
        timezone varchar(255),
        primary key (id_location_details)
    );

    create table location_log_hierarchy (
       id_location_log_hierarchy int8 generated by default as identity,
        effective_from varchar(255),
        effective_to varchar(255),
        parent varchar(255),
        version varchar(255),
        location_business_object_id_location_business_object int8,
        primary key (id_location_log_hierarchy)
    );

    create table location_naming (
       id_location_naming int8 generated by default as identity,
        code varchar(255),
        effective_from varchar(255),
        effective_to varchar(255),
        name varchar(255),
        version varchar(255),
        location_business_object_id_location_business_object int8,
        primary key (id_location_naming)
    );

    create table operator_codes (
       id_operator_codes int8 generated by default as identity,
        partner_roles_id_partner_roles int8,
        primary key (id_operator_codes)
    );

    create table partner_functions (
       id_partner_functions int8 generated by default as identity,
        approval_status varchar(255),
        effective_date varchar(255),
        expiry_date varchar(255),
        function_type_code varchar(255),
        version varchar(255),
        partner_roles_id_partner_roles int8,
        primary key (id_partner_functions)
    );

    create table partner_names (
       id_partner_names int8 generated by default as identity,
        approval_status varchar(255),
        effective_date varchar(255),
        expiry_date varchar(255),
        partner_name1 varchar(255),
        version varchar(255),
        business_object_id_business_object int8,
        primary key (id_partner_names)
    );

    create table partner_roles (
       id_partner_roles int8 generated by default as identity,
        partner_role varchar(255),
        version varchar(255),
        business_object_id_business_object int8,
        primary key (id_partner_roles)
    );

    create table process_data (
       id_process_data int8 generated by default as identity,
        change_type varchar(255),
        version_number varchar(255),
        primary key (id_process_data)
    );

    create table referencing_fi_accounts (
       id_referencing_fi_accounts int8 generated by default as identity,
        effective_date varchar(255),
        fi_account_number varchar(255),
        territory_number varchar(255),
        version varchar(255),
        addresses_id_addresses int8,
        primary key (id_referencing_fi_accounts)
    );

    create table tax_numbers (
       id_tax_numbers int8 generated by default as identity,
        tax_code varchar(255),
        tax_number varchar(255),
        version varchar(255),
        business_object_id_business_object int8,
        primary key (id_tax_numbers)
    );

    alter table if exists addresses 
       add constraint FKkl8ldmkg1oxe49osh61s2cb6j 
       foreign key (business_object_id_business_object) 
       references business_object;

    alter table if exists addresses_overviews 
       add constraint FKbbv8tlyqu4a0qsgnchotki5ij 
       foreign key (addresses_id_addresses) 
       references addresses;

    alter table if exists bill_to_parties 
       add constraint FK897fue8at3k4il7swaagsjg7s 
       foreign key (partner_roles_id_partner_roles) 
       references partner_roles;

    alter table if exists boycott_statuses 
       add constraint FK1l8v08u8khml8mkbckigco1xd 
       foreign key (business_object_id_business_object) 
       references business_object;

    alter table if exists bpma 
       add constraint FKpqwnj4mxdswdev9s475hfmpuj 
       foreign key (business_object_id_business_object) 
       references business_object;

    alter table if exists bpma 
       add constraint FKii33n29d5boluax4jtil8hqog 
       foreign key (process_data_id_process_data) 
       references process_data;

    alter table if exists city 
       add constraint FK4ftdhnnrx6endotxuxjfdd96m 
       foreign key (city_business_object_id_city_business_object) 
       references city_business_object;

    alter table if exists city 
       add constraint FKs211uu8a71hf0ty66glo3yvrr 
       foreign key (process_data_id_process_data) 
       references process_data;

    alter table if exists city_compass_code 
       add constraint FKhshhe63jrpxbutstfjonhdksy 
       foreign key (city_business_object_id_city_business_object) 
       references city_business_object;

    alter table if exists city_location 
       add constraint FKhmd1o8vm4o641rr3dro3stwvd 
       foreign key (city_business_object_id_city_business_object) 
       references city_business_object;

    alter table if exists city_naming 
       add constraint FK9b3pipi3ag1pr04x5clbs7oei 
       foreign key (city_business_object_id_city_business_object) 
       references city_business_object;

    alter table if exists city_postal_code_range 
       add constraint FK7avjpueanfekqd8j5yy2y8kou 
       foreign key (city_business_object_id_city_business_object) 
       references city_business_object;

    alter table if exists city_us_code 
       add constraint FKlcx98eqhas4f5i47s9gicr12c 
       foreign key (city_business_object_id_city_business_object) 
       references city_business_object;

    alter table if exists communication_details 
       add constraint FKijfiw5rmyr2t1e3w5e0xkjedp 
       foreign key (contacts_id_contacts) 
       references contacts;

    alter table if exists communication_preferences 
       add constraint FKblu95xy61i67jw7rho4q3ghh5 
       foreign key (partner_roles_id_partner_roles) 
       references partner_roles;

    alter table if exists contacts 
       add constraint FKp9r6dxmpm2sl11frn9wtgtpnj 
       foreign key (addresses_id_addresses) 
       references addresses;

    alter table if exists ecommerce_channels 
       add constraint FKt5bb53pp4yp02kjcgnbucbwtb 
       foreign key (business_object_id_business_object) 
       references business_object;

    alter table if exists ecommerce_products 
       add constraint FKje0i438awxe3cyrnamfr8ho3a 
       foreign key (ecommerce_channels_id_ecommerce_channels) 
       references ecommerce_channels;

    alter table if exists facility 
       add constraint FKqp4c6ktjrwveciovyhyb92xtb 
       foreign key (facility_business_object_id_facility_business_object) 
       references facility_business_object;

    alter table if exists facility 
       add constraint FKp8ouvyuy0oks99vwpimgoknmf 
       foreign key (process_data_id_process_data) 
       references process_data;

    alter table if exists facility_access 
       add constraint FKg17bpl7qituqwormf7g0fs9rp 
       foreign key (facility_details_id_facility_details) 
       references facility_details;

    alter table if exists facility_business_object 
       add constraint FKbs2huk2fsky671r5mot7xawh5 
       foreign key (facility_facility_details_id_facility_details) 
       references facility_details;

    alter table if exists facility_chronology 
       add constraint FKh9va4qi23oapskwo0mcc3wxbx 
       foreign key (facility_business_object_id_facility_business_object) 
       references facility_business_object;

    alter table if exists facility_chronology 
       add constraint FKheg6k461i9abt1ywwn1tp6abd 
       foreign key (facility_log_hierarchy_id_facility_log_hierarchy) 
       references facility_log_hierarchy;

    alter table if exists facility_chronology 
       add constraint FK22ydphsotwgmr4doy20122ktq 
       foreign key (facility_naming_id_facility_naming) 
       references facility_naming;

    alter table if exists facility_chronology 
       add constraint FKhldjianl404h4ulwlj93nnw3k 
       foreign key (facility_partner_id_facility_partner) 
       references facility_partner;

    alter table if exists facility_compass_code 
       add constraint FKpy14pgsceh04yohtgiw87f5s 
       foreign key (facility_business_object_id_facility_business_object) 
       references facility_business_object;

    alter table if exists facility_cs_code 
       add constraint FKq7pv03dymwc36gu5hnfrvrogq 
       foreign key (facility_business_object_id_facility_business_object) 
       references facility_business_object;

    alter table if exists facility_ext_ref_code_type 
       add constraint FKra3d53at2ll1ao4gwu2bjyme0 
       foreign key (facility_business_object_id_facility_business_object) 
       references facility_business_object;

    alter table if exists facility_function 
       add constraint FK7hjceex11fk8aysoqwfuya44i 
       foreign key (facility_details_id_facility_details) 
       references facility_details;

    alter table if exists facility_hour 
       add constraint FK6bgq1wwgoslmlfj2nvf9aausb 
       foreign key (facility_details_id_facility_details) 
       references facility_details;

    alter table if exists facility_status 
       add constraint FKflmxmm50yry9levu9dr6bplg5 
       foreign key (facility_business_object_id_facility_business_object) 
       references facility_business_object;

    alter table if exists fi_accounts 
       add constraint FKtde519yom6e8ofb8q58tmicnw 
       foreign key (business_object_id_business_object) 
       references business_object;

    alter table if exists formatted_address 
       add constraint FK8hgohfm1ae7ytopoi5qgd57vw 
       foreign key (addresses_id_addresses) 
       references addresses;

    alter table if exists location 
       add constraint FK7gj5tvo790fy3jv2xxvc6at27 
       foreign key (business_object_id_location_business_object) 
       references location_business_object;

    alter table if exists location 
       add constraint FKk61lrakjgi66dy6nmwc36wq4b 
       foreign key (process_data_id_process_data) 
       references process_data;

    alter table if exists location_business_object 
       add constraint FKk6jtbw9jmct3pk6aahij2ieub 
       foreign key (location_details_id_location_details) 
       references location_details;

    alter table if exists location_cs_code 
       add constraint FKlqqypvgi7iylt9hcfklkbjqck 
       foreign key (location_business_object_id_location_business_object) 
       references location_business_object;

    alter table if exists location_log_hierarchy 
       add constraint FK9869xaaqe30p2b9s007a5vkn2 
       foreign key (location_business_object_id_location_business_object) 
       references location_business_object;

    alter table if exists location_naming 
       add constraint FK95m6c2ioxshy5l2dl3c17b6eh 
       foreign key (location_business_object_id_location_business_object) 
       references location_business_object;

    alter table if exists operator_codes 
       add constraint FK23m4tjq7jiftqfvjjwfnl5u4r 
       foreign key (partner_roles_id_partner_roles) 
       references partner_roles;

    alter table if exists partner_functions 
       add constraint FK9axb9iq8enhh1acp0pjcv2rj0 
       foreign key (partner_roles_id_partner_roles) 
       references partner_roles;

    alter table if exists partner_names 
       add constraint FKqfc3woudohfql17cukvhajxf8 
       foreign key (business_object_id_business_object) 
       references business_object;

    alter table if exists partner_roles 
       add constraint FKcafer4on5tot9638l8ae4dk1p 
       foreign key (business_object_id_business_object) 
       references business_object;

    alter table if exists referencing_fi_accounts 
       add constraint FK5fnimql1ypii5w66qe5uup558 
       foreign key (addresses_id_addresses) 
       references addresses;

    alter table if exists tax_numbers 
       add constraint FKt2vq9lk4668bdb5ohpi09r0im 
       foreign key (business_object_id_business_object) 
       references business_object;