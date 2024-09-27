package com.lianpay.globalpay.enums;

import java.util.regex.Pattern;

public enum CountryEnum {
    AF("Afghanistan", "AF", "AFG", "阿富汗", "004", "Asia/Kabul", ""),
    AL("Albania", "AL", "ALB", "阿尔巴尼亚", "008", "Europe/Tirane", "^\\d{4}$"),
    AR("Argentina", "AR", "ARG", "阿根廷", "032", "America/Argentina/Buenos_Aires", "^([A-HJ-NP-Z])?\\d{4}([A-Z]{3})?$"),
    DZ("Algeria", "DZ", "DZA", "阿尔及利亚", "012", "Africa/Algiers", ""),
    AO("Angola", "AO", "AGO", "安哥拉", "024", "Africa/Luanda", ""),
    AW("Aruba", "AW", "ABW", "阿鲁巴", "533", "America/Aruba", ""),
    AU("Australia", "AU", "AUS", "澳大利亚", "036", "Australia/Canberra", "^\\d{4}$"),
    AT("Austria", "AT", "AUT", "奥地利", "040", "Europe/Vienna", "^\\d{4}$"),
    AZ("Azerbaijan", "AZ", "AZE", "阿塞拜疆", "031", "Asia/Baku", ""),
    BS("Bahamas The", "BS", "BHS", "巴哈马群岛", "044", "America/Nassau", ""),
    BH("Bahrain", "BH", "BHR", "巴林", "048", "Asia/Bahrain", ""),
    BD("Bangladesh", "BD", "BGD", "孟加拉国", "050", "Asia/Dhaka", ""),
    BB("Barbados", "BB", "BRB", "巴巴多斯", "052", "America/Barbados", ""),
    BY("Belarus", "BY", "BLR", "白俄罗斯", "112", "Europe/Minsk", "^\\d{6}$"),
    BE("Belgium", "BE", "BEL", "比利时", "056", "Europe/Brussels", "^\\d{4}$"),
    BZ("Belize", "BZ", "BLZ", "伯利兹", "084", "America/Belize", ""),
    BJ("Benin", "BJ", "BEN", "贝宁", "204", "Africa/Porto-Novo", ""),
    BM("Bermuda", "BM", "BMU", "百慕大", "060", "Atlantic/Bermuda", ""),
    BT("Bhutan", "BT", "BTN", "不丹", "064", "Asia/Dhaka", ""),
    BO("Bolivia", "BO", "BOL", "玻利维亚", "068", "America/La_Paz", ""),
    BA("Bosnia and Herzegovina", "BA", "BIH", "波斯尼亚和黑塞哥维那", "070", "Europe/Bucharest", ""),
    BW("Botswana", "BW", "BWA", "博茨瓦纳", "072", "MET", ""),
    BR("Brazil", "BR", "BRA", "巴西", "076", "Brazil/East", "^\\d{5}[\\-]?\\d{3}$"),
    VG("British Virgin Islands", "VG", "VGB", "英属维尔京群岛", "092", "America/Santiago", ""),
    BN("Brunei", "BN", "BRN", "文莱", "096", "Asia/Brunei", "^[A-Z]{2}[ ]?\\d{4}$"),
    BG("Bulgaria", "BG", "BGR", "保加利亚", "100", "Europe/Sofia", "^\\d{4}$"),
    BF("Burkina Faso", "BF", "BFA", "布基纳法索", "854", "Africa/Ouagadougou", ""),
    BI("Burundi", "BI", "BDI", "布隆迪", "108", "Africa/Bujumbura", ""),
    KH("Cambodia", "KH", "KHM", "柬埔寨", "116", "Asia/Phnom_Penh", "^\\d{5}$"),
    CM("Cameroon", "CM", "CMR", "喀麦隆", "120", "Africa/Ndjamena", ""),
    CA("Canada", "CA", "CAN", "加拿大", "124", "America/Toronto", "^[ABCEGHJKLMNPRSTVXY]\\d[ABCEGHJ-NPRSTV-Z][ ]?\\d[ABCEGHJ-NPRSTV-Z]\\d$"),
    CV("Cape Verde", "CV", "CPV", "佛得角", "132", "Atlantic/Cape_Verde", ""),
    KY("Cayman Islands", "KY", "CYM", "开曼群岛", "136", "America/Cayman", ""),
    CF("Central African Republic", "CF", "CAF", "中非共和国", "140", "Canada/Central", ""),
    TD("Chad", "TD", "TCD", "乍得", "148", "Africa/Ndjamena", ""),
    CL("Chile", "CL", "CHL", "智利", "152", "America/Santiago", "^\\d{7}$"),
    CN("China", "CN", "CHN", "中国", "156", "Asia/Shanghai", "^\\d{6}$"),
    CX("Christmas Island", "CX", "CXR", "圣诞岛", "162", "Indian/Christmas", ""),
    CC("Cocos (Keeling)Islands", "CC", "CCK", "科科斯（基林）群岛", "166", "Indian/Cocos", ""),
    CO("Colombia", "CO", "COL", "哥伦比亚", "170", "America/Bogota", "^\\d{6}$"),
    KM("Comoros", "KM", "COM", "科摩罗", "174", "Indian/Comoro", ""),
    CG("Congo Republic of the", "CG", "刚果共和国", "COG", "178", "Africa/Brazzaville", ""),
    CK("Cook Islands", "CK", "COK", "库克群岛", "184", "Pacific/Rarotonga", ""),
    CR("Costa Rica", "CR", "CRI", "哥斯达黎加", "188", "America/Costa_Rica", "^\\d{4,5}|\\d{3}-\\d{4}$"),
    CI("Cote d'Ivoire", "CI", "CIV", "科特迪瓦", "384", "Africa/Bamako", ""),
    HR("Croatia", "HR", "HRV", "克罗地亚", "191", "Europe/Zagreb", "^\\d{5}$"),
    CU("Cuba", "CU", "CUB", "古巴", "192", "Cuba", ""),
    CY("Cyprus", "CY", "CYP", "塞浦路斯", "196", "Asia/Nicosia", "^\\d{4}$"),
    CZ("Czech Republic", "CZ", "捷克共和国", "CZE", "203", "Europe/Prague", "^\\d{3}[ ]?\\d{2}$"),
    DK("Denmark", "DK", "DNK", "丹麦", "208", "Europe/Copenhagen", "^\\d{4}$"),
    DJ("Djibouti", "DJ", "DJI", "吉布提", "262", "Africa/Djibouti", ""),
    DM("Dominica", "DM", "DMA", "多米尼加", "212", "America/Dominica", ""),
    DO("Dominica Rep.", "DO", "DOM", "多米尼加共和国", "214", "America/Dominica", "^\\d{5}$"),
    EC("Ecuador", "EC", "ECU", "厄瓜多尔", "218", "America/Eirunepe", "^\\d{6}$"),
    EG("Egypt", "EG", "EGY", "埃及", "818", "Egypt", ""),
    SV("El Salvador", "SV", "SLV", "萨尔瓦多", "222", "America/El_Salvador", "^\\d{4}$"),
    GQ("Equatorial Guinea", "GQ", "GNQ", "赤道几内亚", "226", "Africa/Malabo", ""),
    ER("Eritrea", "ER", "ERI", "厄立特里亚", "232", "Africa/Asmara", ""),
    EE("Estonia", "EE", "EST", "爱沙尼亚", "233", "Europe/Tallinn", "^\\d{5}$"),
    ET("Ethiopia", "ET", "ETH", "埃塞俄比亚", "231", "Africa/Addis_Ababa", ""),
    FK("Falkland Islands (Islas Malvinas)", "FK", "FLK", "福克兰群岛（马尔维纳斯群岛）", "238", "Atlantic/Stanley", ""),
    FO("Faroe Islands", "FO", "FRO", "法罗群岛", "234", "Atlantic/Faroe", "^FO-\\d{3}$"),
    FJ("Fiji", "FJ", "FJI", "斐济", "242", "Pacific/Fiji", ""),
    FI("Finland", "FI", "FIN", "芬兰", "246", "Europe/Helsinki", "^\\d{5}$"),
    FR("France", "FR", "FRA", "法国", "250", "Europe/Paris", "^\\d{5}$"),
    GF("French Guiana", "GF", "GUF", "法属圭亚那", "254", "America/Cayenne", "^9[78]3\\d{2}$"),
    PF("French Polynesia", "PF", "PYF", "法属波利尼西亚", "258", "Pacific/Gambier", ""),
    GA("Gabon", "GA", "GAB", "加蓬", "266", "Africa/Libreville", ""),
    GM("Gambia The", "GM", "GMB", "冈比亚", "270", "Africa/Banjul", ""),
    GE("Georgia", "GE", "GEO", "格鲁吉亚", "268", "Asia/Tbilisi", ""),
    DE("Germany", "DE", "DEU", "德国", "276", "Europe/Berlin", "^\\d{5}$"),
    GH("Ghana", "GH", "GHA", "加纳", "288", "Africa/Accra", ""),
    GI("Gibraltar", "GI", "GIB", "直布罗陀", "292", "Europe/Gibraltar", ""),
    GR("Greece", "GR", "GRC", "希腊", "300", "Europe/Athens", "^\\d{3}[ ]?\\d{2}$"),
    GL("Greenland", "GL", "GRL", "格陵兰", "304", "America/Danmarkshavn", "^DK-39\\d{2}$"),
    GD("Grenada", "GD", "GRD", "格林纳达", "308", "America/Grenada", ""),
    GP("Guadeloupe", "GP", "GLP", "瓜德罗普", "312", "America/Guadeloupe", "^9[78][01]\\d{2}$"),
    GU("Guam", "GU", "GUM", "关岛", "316", "Pacific/Guam", ""),
    GT("Guatemala", "GT", "GTM", "危地马拉", "320", "America/Guatemala", ""),
    GN("Guinea", "GN", "GIN", "几内亚", "324", "Africa/Conakry", ""),
    GW("Guinea-Bissau", "GW", "GNB", "几内亚比绍", "624", "Africa/Bissau", ""),
    GY("Guyana", "GY", "GUY", "圭亚那", "328", "America/Guyana", ""),
    HT("Haiti", "HT", "HTI", "海地", "332", "America/Lower_Princes", ""),
    VA("Holy See (Vatican City)", "VA", "VAT", "教廷（梵蒂冈城）", "336", "Europe/Vatican", "^00120$"),
    HN("Honduras", "HN", "HND", "洪都拉斯", "340", "America/Tegucigalpa", ""),
    HU("Hungary", "HU", "HUN", "匈牙利", "348", "Europe/Budapest", "^\\d{4}$"),
    IS("Iceland", "IS", "ISL", "冰岛", "352", "Iceland", "^\\d{3}$"),
    IN("India", "IN", "IND", "印度", "356", "Asia/Kolkata", "^\\d{6}$"),
    ID("Indonesia", "ID", "IDN", "印度尼西亚", "360", "Asia/Makassar", "^\\d{5}$"),
    IR("Iran", "IR", "IRN", "伊朗", "364", "Asia/Tehran", ""),
    IQ("Iraq", "IQ", "IRQ", "伊拉克", "368", "Asia/Baghdad", ""),
    IE("Ireland", "IE", "IRL", "爱尔兰", "372", "Europe/Dublin", ""),
    IL("Israel", "IL", "ISR", "以色列", "376", "Israel", "^\\d{7}$"),
    IT("Italy", "IT", "ITA", "意大利", "380", "Europe/Rome", "^\\d{5}$"),
    JM("Jamaica", "JM", "JAM", "牙买加", "388", "America/Jamaica", ""),
    JP("Japan", "JP", "JPN", "日本", "392", "Asia/Tokyo", "^\\d{3}-\\d{4}$"),
    JO("Jordan", "JO", "JOR", "约旦", "400", "Asia/Amman", ""),
    KZ("Kazakhstan", "KZ", "KAZ", "哈萨克斯坦", "398", "Asia/Yangon", "^.{7}$"),
    KE("Kenya", "KE", "KEN", "肯尼亚", "404", "Africa/Nairobi", ""),
    KI("Kiribati", "KI", "KIR", "基里巴斯", "296", "Pacific/Enderbury", ""),
    KP("Korea North", "KP", "PRK", "朝鲜", "408", "Asia/Pyongyang", ""),
    KR("Korea South", "KR", "KOR", "韩国", "410", "Asia/Seoul", ""),
    KW("Kuwait", "KW", "KWT", "科威特", "414", "Asia/Kuwait", "^\\d{5}$"),
    KG("Kyrgyzstan", "KG", "KGZ", "吉尔吉斯斯坦", "417", "Asia/Bishkek", "^\\d{6}$"),
    LA("Laos", "LA", "LAO", "老挝", "418", "Asia/Vientiane", "^\\d{5}$"),
    LV("Latvia", "LV", "LVA", "拉脱维亚", "428", "Europe/Riga", "^LV-\\d{4}$"),
    LB("Lebanon", "LB", "LBN", "黎巴嫩", "422", "Asia/Beirut", ""),
    LS("Lesotho", "LS", "LSO", "莱索托", "426", "Africa/Maseru", ""),
    LR("Liberia", "LR", "LBR", "利比里亚", "430", "Africa/Monrovia", ""),
    LY("Libya", "LY", "LBY", "利比亚", "434", "Libya", ""),
    LI("Liechtenstein", "LI", "LIE", "列支敦士登", "438", "Europe/Vaduz", ""),
    LT("Lithuania", "LT", "LTU", "立陶宛", "440", "Europe/Vilnius", "^\\d{5}$"),
    LU("Luxembourg", "LU", "LUX", "卢森堡", "442", "Europe/Luxembourg", "^\\d{4}$"),
    MK("Macedonia", "MK", "MKD", "马其顿", "807", "Europe/Skopje", "^\\d{4}$"),
    MG("Madagascar", "MG", "MDG", "马达加斯加", "450", "Indian/Antananarivo", ""),
    MW("Malawi", "MW", "MWI", "马拉维", "454", "Africa/Blantyre", ""),
    MY("Malaysia", "MY", "MYS", "马来西亚", "458", "Asia/Kuala_Lumpur", "^\\d{5}$"),
    MV("Maldives", "MV", "MDV", "马尔代夫", "462", "Indian/Maldives", "^\\d{5}$"),
    ML("Mali", "ML", "MLI", "马耳他", "466", "Africa/Bamako", ""),
    MT("Malta", "MT", "MLT", "马耳他", "470", "Europe/Malta", "^[A-Z]{3}[ ]?\\d{2,4}$"),
    MH("Marshall Islands", "MH", "MHL", "马绍尔群岛", "584", "Pacific/Kwajalein", ""),
    MQ("Martinique", "MQ", "MTQ", "马提尼克", "474", "America/Martinique", "^9[78]2\\d{2}$"),
    MR("Mauritania", "MR", "MRT", "毛里塔尼亚", "478", "Africa/Nouakchott", ""),
    MU("Mauritius", "MU", "MUS", "毛里求斯", "480", "Indian/Mauritius", "^\\d{5}$"),
    YT("Mayotte", "YT", "MYT", "马约特", "175", "Indian/Mayotte", "^976\\d{2}$"),
    MX("Mexico", "MX", "MEX", "墨西哥", "484", "America/Mexico_City", "^\\d{5}$"),
    FM("Micronesia Federated States of", "FM", "FSM", "密克罗尼西亚联邦", "583", "Pacific/Chuuk", "^(\\d{4})([ \\-]\\d{4})?$"),
    MD("Moldova", "MD", "MDA", "摩尔多瓦", "498", "Europe/Chisinau", "^\\d{4}$"),
    MC("Monaco", "MC", "MCO", "摩纳哥", "492", "Europe/Monaco", "^980\\d{2}$"),
    MN("Mongolia", "MN", "MNG", "蒙古", "496", "Asia/Choibalsan", "^\\d{5}$"),
    MS("Montserrat", "MS", "MSR", "蒙特塞拉特", "500", "America/Montserrat", ""),
    MA("Morocco", "MA", "MAR", "摩洛哥", "504", "Africa/Luanda", "^\\d{5}$"),
    MZ("Mozambique", "MZ", "MOZ", "莫桑比克", "508", "Africa/Maputo", ""),
    MM("Myanmar (Burma)", "MM", "MMR", "缅甸（缅甸）", "104", "Asia/Rangoon", ""),
    NA("Namibia", "NA", "NAM", "纳米比亚", "516", "Africa/Windhoek", ""),
    NR("Nauru", "NR", "NRU", "瑙鲁", "520", "Pacific/Nauru", ""),
    NP("Nepal", "NP", "NPL", "尼泊尔", "524", "Asia/Kathmandu", "^\\d{5}$"),
    NL("Netherlands", "NL", "NLD", "荷兰", "528", "Europe/Amsterdam", "^\\d{4}[ ]?[A-Z]{2}$"),
    AN("Netherlands Antilles", "AN", "ANT", "荷属安的列斯群岛", "530", "America/Montserrat", ""),
    NC("New Caledonia", "NC", "NCL", "新喀里多尼亚", "540", "Pacific/Noumea", ""),
    NZ("New Zealand", "NZ", "NZL", "新西兰", "554", "Pacific/Auckland", "^\\d{4}$"),
    NI("Nicaragua", "NI", "NIC", "尼加拉瓜", "558", "America/Managua", ""),
    NE("Niger", "NE", "NER", "尼日尔", "562", "Africa/Niamey", ""),
    NG("Nigeria", "NG", "NGA", "尼日利亚", "566", "Europe/London", "^(\\d{6})?$"),
    NU("Niue", "NU", "NIU", "纽埃", "570", "Pacific/Niue", ""),
    NF("Norfolk Island", "NF", "NFK", "诺福克岛", "574", "Pacific/Norfolk", ""),
    MP("Northern Mariana Islands", "MP", "MNP", "北马里亚纳群岛", "580", "Pacific/Saipan", ""),
    NO("Norway", "NO", "NOR", "挪威", "578", "Europe/Oslo", "^\\d{4}$"),
    OM("Oman", "OM", "OMN", "阿曼", "512", "Asia/Muscat", "^\\d{3}$"),
    PK("Pakistan", "PK", "PAK", "巴基斯坦", "586", "Asia/Karachi", ""),
    PW("Palau", "PW", "PLW", "帕劳", "585", "Pacific/Palau", ""),
    PA("Panama", "PA", "PAN", "巴拿马", "591", "America/Panama", "^\\d{4}$"),
    PG("Papua New Guinea", "PG", "PNG", "巴布亚新几内亚", "598", "Pacific/Bougainville", ""),
    PY("Paraguay", "PY", "PRY", "巴拉圭", "600", "America/Asuncion", "^\\d{4}$"),
    PE("Peru", "PE", "PER", "秘鲁", "604", "America/Lima", "^\\d{5}$"),
    PH("Philippines", "PH", "PHL", "菲律宾", "608", "Asia/Manila", "^\\d{4}$"),
    PN("Pitcairn Islands", "PN", "PCN", "皮特凯恩群岛", "612", "Pacific/Pitcairn", ""),
    PL("Poland", "PL", "POL", "波兰", "616", "Poland", "^\\d{2}-\\d{3}$"),
    PT("Portugal", "PT", "PRT", "葡萄牙", "620", "Portugal", "^\\d{4}(\\d{3})?$"),
    PR("Puerto Rico", "PR", "PRI", "波多黎各", "630", "America/Puerto_Rico", ""),
    QA("Qatar", "QA", "QAT", "卡塔尔", "634", "Asia/Qatar", ""),
    RE("Reunion", "RE", "REU", "留尼旺", "638", "Indian/Reunion", "^9[78]4\\d{2}$"),
    RO("Romania", "RO", "ROM", "罗马尼亚", "642", "Europe/Bucharest", "^\\d{6}$"),
    RU("Russia", "RU", "RUS", "俄罗斯", "643", "Europe/Moscow", "^\\d{6}$"),
    RW("Rwanda", "RW", "RWA", "卢旺达", "646", "Africa/Kigali", ""),
    KN("Saint Kitts and Nevis", "KN", "KNA", "圣基茨和尼维斯", "659", "America/St_Kitts", ""),
    LC("Saint Lucia", "LC", "LCA", "圣卢西亚", "662", "America/St_Lucia", ""),
    PM("Saint Pierre and Miquelon", "PM", "SPM", "圣皮埃尔和密克隆", "666", "America/Miquelon", ""),
    VC("Saint Vincent", "VC", "VCT", "圣文森特岛", "670", "America/St_Vincent", ""),
    SM("San Marino", "SM", "SMR", "圣马力诺", "674", "Europe/San_Marino", "^4789\\d"),
    ST("Sao Tome and Principe", "ST", "STP", "圣多美和普林西比", "678", "Africa/Sao_Tome", ""),
    SA("Saudi Arabia", "SA", "SAU", "沙特阿拉伯", "682", "Asia/Riyadh", "^\\d{5}$"),
    SN("Senegal", "SN", "SEN", "塞内加尔", "686", "Africa/Dakar", ""),
    SC("Seychelles", "SC", "SYC", "塞舌尔", "690", "Indian/Mahe", ""),
    SL("Sierra Leone", "SL", "SLE", "塞拉利昂", "694", "Africa/Freetown", ""),
    SG("Singapore", "SG", "SGP", "新加坡", "702", "Asia/Singapore", "^\\d{6}$"),
    SK("Slovakia", "SK", "SVK", "斯洛伐克", "703", "Europe/Bratislava", "^\\d{3}[ ]?\\d{2}$"),
    SI("Slovenia", "SI", "SVN", "斯洛文尼亚", "705", "Europe/Ljubljana", "^\\d{4}$"),
    SB("Solomon Islands", "SB", "SLB", "所罗门群岛", "090", "Pacific/Guadalcanal", ""),
    SO("Somalia", "SO", "SOM", "索马里", "706", "Africa/Mogadishu", ""),
    ZA("South Africa", "ZA", "ZAF", "南非", "710", "Africa/Johannesburg", "^\\d{4}$"),
    ES("Spain", "ES", "ESP", "西班牙", "724", "Europe/Madrid", "^\\d{5}$"),
    LK("Sri Lanka", "LK", "LKA", "斯里兰卡", "144", "Asia/Colombo", "^\\d{5}$"),
    SD("Sudan", "SD", "SDN", "苏丹", "736", "Africa/Khartoum", ""),
    SR("Suriname", "SR", "SUR", "苏里南", "740", "America/Paramaribo", ""),
    SJ("Svalbard", "SJ", "SJM", "斯瓦尔巴", "744", "Arctic/Longyearbyen", ""),
    SZ("Swaziland", "SZ", "SWZ", "斯威士兰", "748", "Africa/Mbabane", ""),
    SE("Sweden", "SE", "SWE", "瑞典", "752", "Europe/Stockholm", "^\\d{3}[ ]?\\d{2}$"),
    CH("Switzerland", "CH", "CHE", "瑞士", "756", "Europe/Belgrade", "^\\d{4}$"),
    SY("Syria", "SY", "SYR", "叙利亚", "760", "Asia/Damascus", ""),
    TW("China Taiwan", "TW", "TWN", "中国台湾", "158", "Asia/Taipei", "^\\d{3}(\\d{2})?$"),
    TJ("Tajikistan", "TJ", "TJK", "塔吉克斯坦", "762", "Asia/Dushanbe", ""),
    TZ("Tanzania", "TZ", "TZA", "坦桑尼亚", "834", "Africa/Dar_es_Salaam", ""),
    TH("Thailand", "TH", "THA", "泰国", "764", "Asia/Bangkok", "^\\d{5}$"),
    TG("Togo", "TG", "TGO", "多哥", "768", "Africa/Lome", ""),
    TK("Tokelau", "TK", "TKL", "托克劳", "772", "Asia/Ashgabat", ""),
    TO("Tonga", "TO", "TON", "汤加", "776", "Pacific/Tongatapu", ""),
    TT("Trinidad and Tobago", "TT", "TTO", "特立尼达和多巴哥", "780", "America/Port_of_Spain", "^\\d{6}$"),
    TN("Tunisia", "TN", "TUN", "突尼斯", "788", "Africa/Tunis", ""),
    TR("Turkey", "TR", "TUR", "土耳其", "792", "Turkey", "^\\d{5}$"),
    TM("Turkmenistan", "TM", "TKM", "土库曼斯坦", "795", "Asia/Ashgabat", ""),
    TC("Turks and Caicos Islands", "TC", "TCA", "特克斯和凯科斯群岛", "796", "America/Grand_Turk", ""),
    TV("Tuvalu", "TV", "TUV", "图瓦卢", "798", "Pacific/Funafuti", ""),
    UG("Uganda", "UG", "UGA", "乌干达", "800", "Africa/Kampala", ""),
    UA("Ukraine", "UA", "UKR", "乌克兰", "804", "Europe/Kiev", "^\\d{5}$"),
    AE("United Arab Emirates", "AE", "ARE", "阿拉伯联合酋长国", "784", "Asia/Dubai", ""),
    GB("United Kingdom", "GB", "GBR", "英国", "826", "Europe/London", "^GIR[ ]?0AA|((AB|AL|B|BA|BB|BD|BH|BL|BN|BR|BS|BT|CA|CB|CF|CH|CM|CO|CR|CT|CV|CW|DA|DD|DE|DG|DH|DL|DN|DT|DY|E|EC|EH|EN|EX|FK|FY|G|GL|GY|GU|HA|HD|HG|HP|HR|HS|HU|HX|IG|IM|IP|IV|JE|KA|KT|KW|KY|L|LA|LD|LE|LL|LN|LS|LU|M|ME|MK|ML|N|NE|NG|NN|NP|NR|NW|OL|OX|PA|PE|PH|PL|PO|PR|RG|RH|RM|S|SA|SE|SG|SK|SL|SM|SN|SO|SP|SR|SS|ST|SW|SY|TA|TD|TF|TN|TQ|TR|TS|TW|UB|W|WA|WC|WD|WF|WN|WR|WS|WV|YO|ZE)(\\d[\\dA-Z]?[ ]?\\d[ABD-HJLN-UW-Z]{2}))|BFPO[ ]?\\d{1,4}$"),
    US("United States", "US", "USA", "美国", "840", "America/New_York", "^\\d{5}([ \\-]\\d{4})?$"),
    UY("Uruguay", "UY", "URY", "乌拉圭", "858", "America/Montevideo", "^\\d{5}$"),
    UZ("Uzbekistan", "UZ", "UZB", "乌兹别克斯坦", "860", "Asia/Tashkent", ""),
    VU("Vanuatu", "VU", "VUT", "瓦努阿图", "548", "Pacific/Efate", ""),
    VE("Venezuela", "VE", "VEN", "委内瑞拉", "862", "America/Anguilla", "^\\d{4}$"),
    VN("Vietnam", "VN", "VNM", "越南", "704", "Asia/Ho_Chi_Minh", "^\\d{6}$"),
    VI("Virgin Islands", "VI", "VIR", "维尔京群岛", "850", "America/St_Thomas", ""),
    WF("Wallis and Futuna", "WF", "WLF", "瓦利斯和富图纳群岛", "876", "Pacific/Wallis", ""),
    EH("Western Sahara", "EH", "ESH", "西撒哈拉", "732", "Africa/El_Aaiun", ""),
    WS("Western Samoa", "WS", "WSM", "西萨摩亚", "882", "Pacific/Apia", "^\\d{4}$"),
    YE("Yemen", "YE", "YEM", "也门", "887", "Asia/Aden", ""),
    ZR("Zaire", "ZR", "ZAR", "扎伊尔", "180", "Africa/Kinshasa", ""),
    ZM("Zambia", "ZM", "ZWB", "赞比亚", "894", "Africa/Lusaka", ""),
    ZW("Zimbabwe", "ZW", "ZWE", "津巴布韦", "716", "Africa/Harare", ""),
    PS("Palestine", "PS", "PSE", "巴勒斯坦", "275", "Asia/Gaza", ""),
    AD("Andorra", "AD", "AND", "安道尔共和国", "020", "Europe/Andorra", ""),
    AG("Antigua and Barbuda", "AG", "ATG", "安地卡及巴布達", "028", "America/Antigua", ""),
    AI("Anguilla", "AI", "AIA", "安圭拉 （英國）", "660", "America/Anguilla", ""),
    AM("Armenia", "AM", "ARM", "亚美尼亚", "051", "Asia/Yerevan", ""),
    AS("American Samoa", "AS", "ASM", "美属萨摩亚（美国）", "016", "Pacific/Pago_Pago", ""),
    AX("Åland Islands", "AX", "ALA", "奥兰（芬蘭）", "248", "Europe/Mariehamn", ""),
    RS("Serbia", "RS", "SRB", "塞爾維亞", "688", "Europe/Belgrade", "^\\d{5}|\\d{6}$"),
    BL("Saint Barthélemy", "BL", "BLM", "圣巴泰勒米（法国）", "652", "America/St_Barthelemy", ""),
    BQ("Bonaire, Sint Eustatius and Saba", "BQ", "BES", "加勒比（荷兰）", "535", "America/Kralendijk", ""),
    SH("Saint Helena, Ascension and Tristan da Cunha", "SH", "SHN", "圣赫勒拿、阿森松和特里斯坦-达库尼亚（英国）", "654", "Atlantic/St_Helena", ""),
    SS("South Sudan", "SS", "SSD", "南蘇丹", "728", "Africa/Juba", ""),
    CD("Congo, Democratic Republic of the", "CD", "COD", "刚果", "180", "Africa/Kinshasa", ""),
    SX("Sint Maarten (Dutch part)", "SX", "SXM", "荷屬聖馬丁（荷蘭）", "534", "America/Lower_Princes", ""),
    CW("Curaçao", "CW", "CUW", "库拉索（荷蘭）", "531", "America/Curacao", ""),
    TL("Timor-Leste", "TL", "TLS", "东帝汶", "626", "Asia/Dili", ""),
    UM("United States Minor Outlying Islands", "UM", "UMI", "美国本土外小岛屿", "581", "Pacific/Wake", ""),
    GG("Guernsey", "GG", "GGY", "根西（英国）", "831", "Europe/Guernsey", ""),
    GS("South Georgia and the South Sandwich Islands", "GS", "SGS", "南乔治亚岛和南桑威奇群岛", "239", "Atlantic/South_Georgia", ""),
    IM("Isle of Man", "IM", "IMN", "马恩岛（英国）", "833", "Europe/Isle_of_Man", ""),
    IO("British Indian Ocean Territory", "IO", "IOT", "英属印度洋领地", "086", "Indian/Chagos", ""),
    JE("Jersey", "JE", "JEY", "澤西（英国）", "832", "Europe/Jersey", ""),
    ME("Montenegro", "ME", "MNE", "蒙特內哥羅", "499", "Europe/Podgorica", "^8\\d{4}$"),
    MF("Saint Martin (French part)", "MF", "MAF", "法属圣马丁", "663", "America/Marigot", ""),
    HK("China Hong Kong", "HK", "HKG", "中国香港", "344", "Asia/Hong_Kong", ""),
    MO("China Macao", "MO", "MAC", "中国澳门", "446", "Asia/Macau", ""),
    YU("Yugoslavia", "YU", "YLU", "南斯拉夫", "860", "Europe/Belgrade", ""),
    AQ("Antarctica", "AQ", "ATA", "南极洲", "10", "Etc/GMT-10", ""),
    BV("Bouvet Island", "BV", "BVT", "布韦岛", "74", "UTC", ""),
    FX("French", "FX", "FXX", "法国本土", "249", "Europe/Paris", ""),
    TF("French Southern Territories", "TF", "ATF", "法属南部和南极领地", "260", "Indian/Kerguelen", ""),
    HM("Heard Island and McDonald Islands", "HM", "HMD", "赫德岛和麦克唐纳群岛", "334", "Indian/Kerguelen", ""),
    XK("Kosovo", "XK", "XKS", "科索沃", "0", "CET", ""),
    UN("United Nations", "UN", "UNO", "联合国", "0", "", ""),
    EU("European union", "EU", "EUE", "欧盟", "0", "", ""),
    WI("The Federation of the West Indies", "WI", "EUE", "西印度群岛联邦", "0", "", ""),
    EN("Commonwealth of Independent States", "EN", "EUN", "独联体", "0", "", ""),
    YG("Yugoslavia", "YG", "YUG", "南斯拉夫", "0", "Europe/Belgrade", ""),
    UR("Soviet Union", "UR", "URS", "苏联", "0", "", ""),
    DH("Kingdom of Dahomey", "DH", "DAH", "达荷美", "0", "", ""),
    VL("The Republic Of Upper Volta", "VL", "VOL", "上沃尔特", "0", "", "");

    private final String code;

    private final String threeName;

    private final String fullName;

    private final String cnFullName;

    private final String number;

    private final String timeZone;

    private final String postcodePattern;

    CountryEnum(String fullName, String code,
                String threeName, String cnFullName,
                String number, String timeZone,
                String postcodePattern) {
        this.code = code;
        this.threeName = threeName;
        this.fullName = fullName;
        this.cnFullName = cnFullName;
        this.number = number;
        this.timeZone = timeZone;
        this.postcodePattern = postcodePattern;
    }

    public static Boolean checkCountry(String name) {
        for (CountryEnum country : CountryEnum.values()) {
            if (country.name().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyPostcode(String postcode) {
        return postcode == null
                || "".equals(this.getPostcodePattern())
                || Pattern.matches(this.getPostcodePattern(), postcode);
    }

    public String getCode() {
        return code;
    }

    public String getThreeName() {
        return threeName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCnFullName() {
        return cnFullName;
    }

    public String getNumber() {
        return number;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getPostcodePattern() {
        return postcodePattern;
    }

}
