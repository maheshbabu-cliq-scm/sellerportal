package com.sellerportal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;


import javax.persistence.*;

@Entity
@Table(name = "ISMCND")
public class Ismcnd implements Serializable {

	 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ismcnd_sequence")
	@SequenceGenerator(name = "ismcnd_sequence", sequenceName = "ISMCND_CNDRFNUM_SEQ", allocationSize = 1)
	@Column(name = "CNDRFNUM")
    private Long cndrfnum;

	@Column(name = "CNDCODE", nullable = false, length = 4)
    private String cndcode;

    @Column(name = "CNDDESC", nullable = false, length = 254)
    private String cnddesc;

    @Column(name = "CNDGROUP", nullable = false, length = 128)
    private String cndgroup;

    @Column(name = "CREATEDATE", nullable = false)
    private Date createdate;

    @Column(name = "CREATEDBY", nullable = false)
    private Long createdby;

    @Column(name = "DELETED", nullable = false, length = 1)
    private String deleted;

    @Column(name = "MODIDATE", nullable = false)
    private Date modidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CNDCNDRFNUM") 
    private Ismcnd ismcnd;

//    /** persistent field */
//    private Set crmcfasByCfacndcasetype;
//
//    /** persistent field */
//    private Set crmcfasByCfacndfeedbacktype;

//    /** persistent field */
//    private Set crmcfasByCfacndassignto;

//    /** persistent field */
//    private Set ismidas;

    @OneToMany(mappedBy = "ismcndByCrpcndbatchtype", cascade = CascadeType.ALL)
    private Set<Ismcrp> ismcrpsByCrpcndbatchtype;

    @OneToMany(mappedBy = "ismcndByCrpcndremark", cascade = CascadeType.ALL)
    private Set<Ismcrp> ismcrpsByCrpcndremark;

    @OneToMany(mappedBy = "ismcndByCrpcndreason", cascade = CascadeType.ALL)
    private Set<Ismcrp> ismcrpsByCrpcndreason;

//    /** persistent field */
//    private Set ismprts;
//
//    /** persistent field */
//    private Set crmlhtsByLhtcndresotype;
//
//    /** persistent field */
//    private Set crmlhtsByLhtcndleadsource;
//
//    /** persistent field */
//    private Set crmlhtsByLhtcndzip;
//
//    /** persistent field */
//    private Set crmlhtsByLhtcndfeedbacktype;
//
//    /** persistent field */
//    private Set crmlhtsByLhtcndleadtype;
//
//    /** persistent field */
//    private Set crmlhtsByLhtcndcity;
//
//    /** persistent field */
//    private Set crmlhtsByLhtcndstate;

    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismsem> ismsems;

    @OneToMany(mappedBy = "ismcndByLnfcndopt",  fetch = FetchType.LAZY)
    private Set<Ismlnf> ismlnfsByLnfcndopt;

    @OneToMany(mappedBy = "ismcndByLnfcndent",  fetch = FetchType.LAZY)
    private Set<Ismlnf> ismlnfsByLnfcndent;

    @OneToMany(mappedBy = "ismcndByLnfcnddel",  fetch = FetchType.LAZY)
    private Set<Ismlnf> ismlnfsByLnfcnddel;

//    /** persistent field */
//    private Set ismrpts;

//    /** persistent field */
//    private Set crmcdtsByCdtcndtodispositiontype;
//
//    /** persistent field */
//    private Set crmcdtsByCdtcnddispositiontype;
//
//    /** persistent field */
//    private Set crmcdtsByCdtcndcasetype;

    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismppm> ismppms;

    @OneToMany(mappedBy = "ISMCND",  fetch = FetchType.LAZY)
    private Set<Ismrdt> ismrdts;

//    @OneToMany(mappedBy = "ismcndByUatcndtitle",  fetch = FetchType.LAZY)
//    private Set<Ismuat> ismuatsByUatcndtitle;
//
//    @OneToMany(mappedBy = "ismcndcountry",  fetch = FetchType.LAZY)
//    private Set<Ismuat> ismuatsByUatcndcountry;
//
//    @OneToMany(mappedBy = "ismcndcity",  fetch = FetchType.LAZY)
//    private Set<Ismuat> ismuatsByUatcndcity;
//
//    @OneToMany(mappedBy = "ismcndstate",  fetch = FetchType.LAZY)
//    private Set<Ismuat> ismuatsByUatcndstate;

    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismeml> ismemls;

    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismsdc> ismsdcs;

//    /** persistent field */
//    private Set ismpdts;

    @OneToMany(mappedBy = "ismcndByIdmcndname",  fetch = FetchType.LAZY)
    private Set<Ismidm> ismidmsByIdmcndname;

    @OneToMany(mappedBy = "ismcndByIdmcndprotocol",  fetch = FetchType.LAZY)
    private Set<Ismidm> ismidmsByIdmcndprotocol;

    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismmcc> ismmccs;

    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismpco> ismpcos;

    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismpfi> ismpfis;

    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismubi> ismubis;

//    /** persistent field */
//    private Set ismssisBySsicndtitle;
//
//    /** persistent field */
//    private Set ismssisBySsicndvendortype;
//
//    /** persistent field */
//    private Set ismssisBySsicndstaffstrgnth;

//    /** persistent field */
//    private Set ismssisBySsicndannualto;

    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Octapp> octapps;

    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismcnd> ismcnds;

    @OneToMany(mappedBy = "ismcndByIatcndbusid",  fetch = FetchType.LAZY)
    private Set<Octiat> octiatsByIatcndbusid;

    @OneToMany(mappedBy = "ismcndByIatcndchannelid",  fetch = FetchType.LAZY)
    private Set<Octiat> octiatsByIatcndchannelid;
// ismotl not defined in ismcnd
//    @OneToMany(mappedBy = "otlcndcanrefinstracc",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndcanrefinstracc;
//
//    @OneToMany(mappedBy = "otlcndrtotype",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndrtotype;
//
//    @OneToMany(mappedBy = "otlaltcityrfnum",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndaltcity;
//
//    @OneToMany(mappedBy = "otlcnemioptions",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndemioptions;
//
//    @OneToMany(mappedBy = "ismcndByOtlcndaltcntry",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndaltcntry;
//
//    @OneToMany(mappedBy = "ismcndByOtlcndcanrefreason",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndcanrefreason;
//
//    @OneToMany(mappedBy = "ismcndByOtlcndcancreason",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndcancreason;
//
//    @OneToMany(mappedBy = "ismcndByOtlcndretreason",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndretreason;
//
//    @OneToMany(mappedBy = "ismcndByOtlcndrefreason",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndrefreason;
//
//    @OneToMany(mappedBy = "ismcndByOtlcndcanrefreson",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndcanrefreson;
//
//    @OneToMany(mappedBy = "ismcndByOtlcndaltstate",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndaltstate;
//
//    @OneToMany(mappedBy = "ismcndByOtlcndinitiatedby",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndinitiatedby;
//
//    @OneToMany(mappedBy = "ismcndByOtlcndrefundby",  fetch = FetchType.LAZY)
//    private Set<Ismotl> ismotlsByOtlcndrefundby;

    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismoem> ismoems;
//in ismccd not defined ismcnd
//    @OneToMany(mappedBy = "ismcndByCcdcndlocidcity",  fetch = FetchType.LAZY)
//    private Set<Ismccd> ismccdsByCcdcndlocidcity;
//
//    @OneToMany(mappedBy = "ismcndByCcdcndstate",  fetch = FetchType.LAZY)
//    private Set<Ismccd> ismccdsByCcdcndstate;
//
//    @OneToMany(mappedBy = "ismcndByCcdcndcity",  fetch = FetchType.LAZY)
//    private Set<Ismccd> ismccdsByCcdcndcity;
//
//    @OneToMany(mappedBy = "ismcndByCcdcndcountry",  fetch = FetchType.LAZY)
//    private Set<Ismccd> ismccdsByCcdcndcountry;

    /** persistent field */
    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismpmt> ismpmts;

    // One-to-many association with Ismdpp
    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismdpp> ismdpps;

    // in ismpot ismcnd is not defined
//    @OneToMany(mappedBy = "someEntityByPotbusinessid",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotbusinessid;
//
//    @OneToMany(mappedBy = "someEntityByPotpaymodetype",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotpaymodetype;
//
//    @OneToMany(mappedBy = "someEntityByPotcndemioptions",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndemioptions;
//
//    @OneToMany(mappedBy = "someEntityByPotcndrefreason",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndrefreason;
//
// // One-to-many association with Ismpot (mapped by POTCNDREFUNDBY)
//    @OneToMany(mappedBy = "someEntityByPotcndrefundby",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndrefundby;
//
//    // One-to-many association with Ismpot (mapped by POTBILLCOUNTRYRFNUM)
//    @OneToMany(mappedBy = "someEntityByPotcndbillcountry",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndbillcountry;
//
//    // One-to-many association with Ismpot (mapped by POTCNDRETREASON)
//    @OneToMany(mappedBy = "someEntityByPotcndretreason",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndretreason;
//
//    // One-to-many association with Ismpot (mapped by POTCNDCANREFREASON)
//    @OneToMany(mappedBy = "someEntityByPotcndcanrefreason",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndcanrefreason;
//
//    // One-to-many association with Ismpot (mapped by POTCNDLEADSOURCE)
//    @OneToMany(mappedBy = "someEntityByPotcndleadsource",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndleadsource;
//
//    // One-to-many association with Ismpot (mapped by POTCNDCANREFRESON)
//    @OneToMany(mappedBy = "someEntityByPotcndcanrefreson",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndcanrefreson;
//
//    // One-to-many association with Ismpot (mapped by POTCNDCANCREASON)
//    @OneToMany(mappedBy = "someEntityByPotcndcancreason",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndcancreason;
//
//    // One-to-many association with Ismpot (mapped by POTCNDRTOTYPE)
//    @OneToMany(mappedBy = "someEntityByPotcndrtotype",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndrtotype;
//
//    // One-to-many association with Ismpot (mapped by POTBILLSTATERFNUM)
//    @OneToMany(mappedBy = "someEntityByPotcndbillstate",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndbillstate;
//
//    // One-to-many association with Ismpot (mapped by POTCNDCARDTYPE)
//    @OneToMany(mappedBy = "someEntityByPotcndcardtype",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndcardtype;
//
//    // One-to-many association with Ismpot (mapped by POTCNDCANREFINSTRACC)
//    @OneToMany(mappedBy = "someEntityByPotcndcanrefinstracc",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndcanrefinstracc;
//
//    // One-to-many association with Ismpot (mapped by POTCNDINITIATEDBY)
//    @OneToMany(mappedBy = "someEntityByPotcndinitiatedby",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotcndinitiatedby;
//
//    // One-to-many association with Ismpot (mapped by POTBILLCITYRFNUM)
//    @OneToMany(mappedBy = "someEntityByPotbillcityrfnum",  fetch = FetchType.LAZY)
//    private Set<Ismpot> ismpotsByPotbillcityrfnum;

//
//    /** persistent field */
//    private Set ismsdtsBySdtcndcountry;
//
//    /** persistent field */
//    private Set ismsdtsBySdtcndstate;
//
//    /** persistent field */
//    private Set ismsdtsBySdtcndcity;

 // One-to-many association with Ismbpm (mapped by BPMCNDBUSINESSID)
    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismbpm> ismbpms;

//    /** persistent field */
//    private Set crmcptsByCptcnddispositiontype;
//
//    /** persistent field */
//    private Set crmcptsByCptcndcasetype;
//
//    /** persistent field */
//    private Set crmpcmsByPcmcndstate;
//
//    /** persistent field */
//    private Set crmpcmsByPcmcndcity;

    @OneToMany(mappedBy = "ismcndByAfmcndbusinessid",  fetch = FetchType.LAZY)
    private Set<Ismafm> ismafmsByAfmcndbusinessid;

    // One-to-many association with Ismafm (mapped by AFMCNDCHANNELID)
    @OneToMany(mappedBy = "ismcndByAfmcndchannelid",  fetch = FetchType.LAZY)
    private Set<Ismafm> ismafmsByAfmcndchannelid;

    // One-to-many association with Ismsct (mapped by SCTCNDDEFFIELD)
    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismsct> ismscts;

    // in ismpbi ismcnd is not defined
//    @OneToMany(mappedBy = "someEntityByPbicndpreprocess",  fetch = FetchType.LAZY)
//    private Set<Ismpbi> ismpbisByPbicndpreprocess;
//
//    // One-to-many association with Ismpbi (mapped by PBICNDCHANNELID)
//    @OneToMany(mappedBy = "someEntityByPbicndchannelid",  fetch = FetchType.LAZY)
//    private Set<Ismpbi> ismpbisByPbicndchannelid;
//
//    // One-to-many association with Ismpbi (mapped by PBICNDSDSHIPPER)
//    @OneToMany(mappedBy = "someEntityByPbicndsdshipper",  fetch = FetchType.LAZY)
//    private Set<Ismpbi> ismpbisByPbicndsdshipper;
//
//    // One-to-many association with Ismpbi (mapped by PBICNDPRODTYPE)
//    @OneToMany(mappedBy = "someEntityByPbicndprodtype",  fetch = FetchType.LAZY)
//    private Set<Ismpbi> ismpbisByPbicndprodtype;
//
//    // One-to-many association with Ismpbi (mapped by PBICNDWTUNIT)
//    @OneToMany(mappedBy = "someEntityByPbicndwtunit",  fetch = FetchType.LAZY)
//    private Set<Ismpbi> ismpbisByPbicndwtunit;
//
//    // One-to-many association with Ismpbi (mapped by PBICNDHLWUNIT)
//    @OneToMany(mappedBy = "someEntityByPbicndhlwunit",  fetch = FetchType.LAZY)
//    private Set<Ismpbi> ismpbisByPbicndhlwunit;
//
//    // One-to-many association with Ismpbi (mapped by PBICNDPFTYPE)
//    @OneToMany(mappedBy = "someEntityByPbicndpftype",  fetch = FetchType.LAZY)
//    private Set<Ismpbi> ismpbisByPbicndpftype;
//
//    // One-to-many association with Ismpbi (mapped by PBICNDPFPOSTPRO)
//    @OneToMany(mappedBy = "someEntityByPbicndpfpostpro",  fetch = FetchType.LAZY)
//    private Set<Ismpbi> ismpbisByPbicndpfpostpro;
//
//    // One-to-many association with Ismpbi (mapped by PBICNDPFEXPUNIT)
//    @OneToMany(mappedBy = "someEntityByPbicndpfexpunit",  fetch = FetchType.LAZY)
//    private Set<Ismpbi> ismpbisByPbicndpfexpunit;

    // One-to-many association with Ismccz (mapped by CCZCNDZIP)
    @OneToMany(mappedBy = "ismcndByCczcndzip",  fetch = FetchType.LAZY)
    private Set<Ismccz> ismcczsByCczcndzip;

    // One-to-many association with Ismccz (mapped by CCZCNDCNTRY)
    @OneToMany(mappedBy = "ismcndByCczcndcntry",  fetch = FetchType.LAZY)
    private Set<Ismccz> ismcczsByCczcndcntry;

    @OneToMany(mappedBy = "ismcndByCczcndcity",  fetch = FetchType.LAZY)
    private Set<Ismccz> ismcczsByCczcndcity;
//
//    /** persistent field */
//    private Set ismrlmsByRlmcndstaterfnum;
//
//    /** persistent field */
//    private Set ismrlmsByRlmcndcityrfnum;

 // One-to-many association with Ismhlms (mapped by HLMCNDREASON)
    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismhlm> ismhlms;

    // One-to-many association with Ismapm (mapped by APMCNDMODULE)
    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismapm> ismapms;

    // One-to-many association with Ismzvm (mapped by ZVMCITY)
    @OneToMany(mappedBy = "ismcndByZvmcity",  fetch = FetchType.LAZY)
    private Set<Ismzvm> ismzvmsByZvmcity;

    // One-to-many association with Ismzvm (mapped by ZVMCNDZIP)
    @OneToMany(mappedBy = "ismcndByZvmcndzip",  fetch = FetchType.LAZY)
    private Set<Ismzvm> ismzvmsByZvmcndzip;

    // in ismstl ismcnd not defined
//    @OneToMany(mappedBy = "someOtherEntityByStlcndreqrepinstrven",  fetch = FetchType.LAZY)
//    private Set<Ismstl> ismstlsByStlcndreqrepinstrven;
//
//    // One-to-many association with Ismstl (mapped by STLREASON11CND)
//    @OneToMany(mappedBy = "someOtherEntityByStlreason11cnd",  fetch = FetchType.LAZY)
//    private Set<Ismstl> ismstlsByStlreason11cnd;
//
//    // One-to-many association with Ismstl (mapped by STLCNDTOBEVERREASON)
//    @OneToMany(mappedBy = "someOtherEntityByStlcndtobeverreason",  fetch = FetchType.LAZY)
//    private Set<Ismstl> ismstlsByStlcndtobeverreason;
//
//    // One-to-many association with Ismstl (mapped by STLCNDPAYPROC)
//    @OneToMany(mappedBy = "someOtherEntityByStlcndpayproc",  fetch = FetchType.LAZY)
//    private Set<Ismstl> ismstlsByStlcndpayproc;
//
//    // One-to-many association with Ismstl (mapped by STLCNDCANREFINSTRACC)
//    @OneToMany(mappedBy = "someOtherEntityByStlcndcanrefinstracc",  fetch = FetchType.LAZY)
//    private Set<Ismstl> ismstlsByStlcndcanrefinstracc;
//
//    // One-to-many association with Ismstl (mapped by STLCNDINITIATEDBY)
//    @OneToMany(mappedBy = "someOtherEntityByStlcndinitiatedby",  fetch = FetchType.LAZY)
//    private Set<Ismstl> ismstlsByStlcndinitiatedby;
//
//    // One-to-many association with Ismstl (mapped by STLCNDCANREFREASON)
//    @OneToMany(mappedBy = "someOtherEntityByStlcndcanrefreason",  fetch = FetchType.LAZY)
//    private Set<Ismstl> ismstlsByStlcndcanrefreason;
//
//    // One-to-many association with Ismstl (mapped by STLCNDREFREASON)
//    @OneToMany(mappedBy = "someOtherEntityByStlcndrefreason",  fetch = FetchType.LAZY)
//    private Set<Ismstl> ismstlsByStlcndrefreason;
//
//    // One-to-many association with Ismstl (mapped by STLCNDCHQNOTCLRREA)
//    @OneToMany(mappedBy = "someOtherEntityByStlcndchqnotclrrea",  fetch = FetchType.LAZY)
//    private Set<Ismstl> ismstlsByStlcndchqnotclrrea;
//
//    // One-to-many association with Ismstl (mapped by STLCNDCANCREASON)
//    @OneToMany(mappedBy = "someOtherEntityByStlcndcancreason",  fetch = FetchType.LAZY)
//    private Set<Ismstl> ismstlsByStlcndcancreason;
//
//    /** persistent field */
//    private Set ismstlsByStlcndpaynotproc;
//
//    /** persistent field */
//    private Set ismstlsByStlcndemioptions;
//
//    /** persistent field */
//    private Set ismstlsByStlchknbnkdrescnd;
//
//    /** persistent field */
//    private Set ismstlsByStlcndcanrefreson;
//
//    /** persistent field */
//    private Set ismstlsByStlcndaltcntry;
//
//    /** persistent field */
//    private Set ismstlsByStlcndalttitle;
//
//    /** persistent field */
//    private Set ismstlsByStlcndchqreqinstracc;
//
//    /** persistent field */
//    private Set ismstlsByStlcndreqrepreason;
//
//    /** persistent field */
//    private Set ismstlsByStlcndtobeverinstrcrm;
//
//    /** persistent field */
//    private Set ismstlsByStlcndaltcity;
//
//    /** persistent field */
//    private Set ismstlsByStlcndacccanref;
//
//    /** persistent field */
//    private Set ismstlsByStlreason12cnd;
//
//    /** persistent field */
//    private Set ismstlsByStlcndsalretreason;
//
//    /** persistent field */
//    private Set ismstlsByStlchkundclrrescnd;
//
//    /** persistent field */
//    private Set ismstlsByStlretreson;
//
//    /** persistent field */
//    private Set ismstlsByStlcndaltstate;
//
//    /** persistent field */
//    private Set ismstlsByStlcndsalretinstracc;
//
//    /** persistent field */
//    private Set ismstlsByStlcndrefundby;
//
//    /** persistent field */
//    private Set ismstlsByStlcndrtotype;
//
//    /** persistent field */
//    private Set ismstlsByStlcndsalretinstrven;
//
//    /** persistent field */
//    private Set ismstlsByStlcndrefinstracc;

//    /** persistent field */
//    private Set ismpstsByPstcndtobeverinstrcrm;
//
//    /** persistent field */
//    private Set ismpstsByPstcndsalretinstracc;
//
//    /** persistent field */
//    private Set ismpstsByPstcndreqrepinstrven;
//
//    /** persistent field */
//    private Set ismpstsByPstcndcanrefreson;
//
//    /** persistent field */
//    private Set ismpstsByPstcndrefinstracc;
//
//    /** persistent field */
//    private Set ismpstsByPstcndinitiatedby;
//
//    /** persistent field */
//    private Set ismpstsByPstcndrefreason;
//
//    /** persistent field */
//    private Set ismpstsByPstcndrtotype;
//
//    /** persistent field */
//    private Set ismpstsByPstcndrecvcity;
//
//    /** persistent field */
//    private Set ismpstsByPstcndpaynotproc;
//
//    /** persistent field */
//    private Set ismpstsByPstcndretreason;
//
//    /** persistent field */
//    private Set ismpstsByPstcndemioptions;
//
//    /** persistent field */
//    private Set ismpstsByPstreason11cnd;
//
//    /** persistent field */
//    private Set ismpstsByPstcndsalretreason;
//
//    /** persistent field */
//    private Set ismpstsByPstsalereturn;
//
//    /** persistent field */
//    private Set ismpstsByPstcndpftype;
//
//    /** persistent field */
//    private Set ismpstsByPstreason12cnd;
//
//    /** persistent field */
//    private Set ismpstsByPstcndmercountry;
//
//    /** persistent field */
//    private Set ismpstsByPstcndpayproc;
//
//    /** persistent field */
//    private Set ismpstsByPstcndrecvcountry;
//
//    /** persistent field */
//    private Set ismpstsByPstchknbnkdrescnd;
//
//    /** persistent field */
//    private Set ismpstsByPstcndalttitle;
//
//    /** persistent field */
//    private Set ismpstsByPstcndmerstate;
//
//    /** persistent field */
//    private Set ismpstsByPstcndpostprocess;
//
//    /** persistent field */
//    private Set ismpstsByPstcndrecvstate;
//
//    /** persistent field */
//    private Set ismpstsByPstcndchqnotclrrea;
//
//    /** persistent field */
//    private Set ismpstsByPstcndpreprocess;
//
//    /** persistent field */
//    private Set ismpstsByPstcndtobeverreason;
//
//    /** persistent field */
//    private Set ismpstsByPstcndchannelid;
//
//    /** persistent field */
//    private Set ismpstsByPstcndaltstate;
//
//    /** persistent field */
//    private Set ismpstsByPstcndcanrefinstracc;
//
//    /** persistent field */
//    private Set ismpstsByPstcndaltcity;
//
//    /** persistent field */
//    private Set ismpstsByPstchkundclrrescnd;
//
//    /** persistent field */
//    private Set ismpstsByPstcndacccanref;
//
//    /** persistent field */
//    private Set ismpstsByPstcndreqrepreason;
//
//    /** persistent field */
//    private Set ismpstsByPstcndaltcntry;
//
//    /** persistent field */
//    private Set ismpstsByPstcndrefundby;
//
//    /** persistent field */
//    private Set ismpstsByPstcndcanrefreason;
//
//    /** persistent field */
//    private Set ismpstsByPstcndchqreqinstracc;
//
//    /** persistent field */
//    private Set ismpstsByPstcndsalretinstrven;
//
//    /** persistent field */
//    private Set ismpstsByPstcndcancreason;
//
//    /** persistent field */
//    private Set ismpstsByPstcndmercity;
//
//    /** persistent field */
//    private Set ismbsisByBsicndmaristat;
//
//    /** persistent field */
//    private Set ismbsisByBsicndhouseincm;
//
//    /** persistent field */
//    private Set ismbsisByBsicndeducation;
//
//    /** persistent field */
//    private Set ismbsisByBsicndoccupation;

 // One-to-many association with Ismidc (mapped by IDCCNDPTYPE)
    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismidc> ismidcs;

    // One-to-many association with Ismdat (mapped by DATCNDADGRP)
    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismdat> ismdats;

    @OneToMany(mappedBy = "ismcndByUeacndoccur",  fetch = FetchType.LAZY)
    private Set<Octuea> octueasByUeacndoccur;

    // One-to-many association with Octuea (mapped by UEACNDEVENT)
    @OneToMany(mappedBy = "ismcndByUeacndevent",  fetch = FetchType.LAZY)
    private Set<Octuea> octueasByUeacndevent;

    // One-to-many association with Ismapr (mapped by APRCNDTYPE)
    @OneToMany(mappedBy = "ismcndByAprcndtype",  fetch = FetchType.LAZY)
    private Set<Ismapr> ismaprsByAprcndtype;

    // One-to-many association with Ismapr (mapped by APRCNDELEMENT)
    @OneToMany(mappedBy = "ismcndByAprcndelement",  fetch = FetchType.LAZY)
    private Set<Ismapr> ismaprsByAprcndelement;

//    /** persistent field */
// 
//    /** persistent field */
//    private Set ismpilsByPilcndpricetype;
//
//    /** persistent field */
//    private Set ismpilsByPilcndinvnttype;
//
//    /** persistent field */
//    private Set crmcttsByCttcndtodispositiontype;

//    /** persistent field */
//    private Set crmcttsByCttcndfeedbacktype;
//
//    /** persistent field */
//    private Set crmcttsByCttcndcaseassignto;
//
//    /** persistent field */
//    private Set crmcttsByCttcnddispositiontype;
//
//    /** persistent field */
//    private Set crmcttsByCttcndcasetype;
//
//    /** persistent field */
//    private Set ismsclsBySclcndhlwunit;
//
//    /** persistent field */
//    private Set ismsclsBySclcndwunit;

    @OneToMany(mappedBy = "ISMCND",  fetch = FetchType.LAZY)
    private Set<Ismsml> ismsmls;

    // One-to-many association with Ismpml (mapped by PMLCNDPDURUNIT)
    @OneToMany(mappedBy = "ismcndByPmlcndpdurunit",  fetch = FetchType.LAZY)
    private Set<Ismpml> ismpmlsByPmlcndpdurunit;

    // One-to-many association with Ismpml (mapped by PMLCNDPRICETY)
    @OneToMany(mappedBy = "ismcndByPmlcndpricety",  fetch = FetchType.LAZY)
    private Set<Ismpml> ismpmlsByPmlcndpricety;

    // One-to-many association with Ismscm (mapped by SCMCNDDELIVERYCITY)
    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismscm> ismscms;

    // One-to-many association with Ismose (mapped by OSECNDBUSINESSID)
    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismose> ismoses;

    // One-to-many association with Ismmtm (mapped by MTMCNDUSERTYPE)
    @OneToMany(mappedBy = "ismcnd",  fetch = FetchType.LAZY)
    private Set<Ismmtm> ismmtms;


//    /** persistent field */
//    private Set crmchtsByChtcndcaseassignto;
//
//    /** persistent field */
//    private Set crmchtsByChtcndcity;
//
//    /** persistent field */
//    private Set crmchtsByChtcndfeedbacktype;
//
//    /** persistent field */
//    private Set crmchtsByChtcndcasetype;
//
//    /** persistent field */
//    private Set crmchtsByChtcnddisptype;
//
//    /** persistent field */
//    private Set crmchtsByChtcndstate;
//    
//    /** persistent field */
//    private Set ismccasByCndagenttype;
//    
//    /** persistent field */
//    private Set ismssisBySsicndSla;
    
    @Column(name = "CNDVALUE", nullable = false, length = 256)
    private String cndvalue;


    /** full constructor */
    public Ismcnd(String cndcode, String cnddesc, String cndgroup, Date createdate, Long createdby, String deleted, Date modidate, com.sellerportal.model.Ismcnd ismcnd, Set crmcfasByCfacndcasetype, Set crmcfasByCfacndfeedbacktype, Set crmcfasByCfacndassignto, Set ismidas, Set ismcrpsByCrpcndbatchtype, Set ismcrpsByCrpcndremark, Set ismcrpsByCrpcndreason, Set ismprts, Set crmlhtsByLhtcndresotype, Set crmlhtsByLhtcndleadsource, Set crmlhtsByLhtcndzip, Set crmlhtsByLhtcndfeedbacktype, Set crmlhtsByLhtcndleadtype, Set crmlhtsByLhtcndcity, Set crmlhtsByLhtcndstate, Set ismsems, Set ismlnfsByLnfcndopt, Set ismlnfsByLnfcndent, Set ismlnfsByLnfcnddel, Set ismrpts, Set crmcdtsByCdtcndtodispositiontype, Set crmcdtsByCdtcnddispositiontype, Set crmcdtsByCdtcndcasetype, Set ismppms, Set ismrdts, Set ismuatsByUatcndtitle, Set ismuatsByUatcndcountry, Set ismuatsByUatcndcity, Set ismuatsByUatcndstate, Set ismemls, Set ismsdcs, Set ismpdts, Set ismidmsByIdmcndname, Set ismidmsByIdmcndprotocol, Set ismmccs, Set ismpcos, Set ismpfis, Set ismubis, Set ismssisBySsicndtitle, Set ismssisBySsicndvendortype, Set ismssisBySsicndstaffstrgnth, Set ismssisBySsicndannualto, Set octapps, Set ismcnds, Set octiatsByIatcndbusid, Set octiatsByIatcndchannelid, Set ismotlsByOtlcndcanrefinstracc, Set ismotlsByOtlcndrtotype, Set ismotlsByOtlcndaltcity, Set ismotlsByOtlcndemioptions, Set ismotlsByOtlcndaltcntry, Set ismotlsByOtlcndcanrefreason, Set ismotlsByOtlcndcancreason, Set ismotlsByOtlcndretreason, Set ismotlsByOtlcndrefreason, Set ismotlsByOtlcndcanrefreson, Set ismotlsByOtlcndaltstate, Set ismotlsByOtlcndinitiatedby, Set ismotlsByOtlcndrefundby, Set ismoems, Set ismccdsByCcdcndlocidcity, Set ismccdsByCcdcndstate, Set ismccdsByCcdcndcity, Set ismccdsByCcdcndcountry, Set ismpmts, Set ismdpps, Set ismpotsByPotbusinessid, Set ismpotsByPotpaymodetype, Set ismpotsByPotcndemioptions, Set ismpotsByPotcndrefreason, Set ismpotsByPotcndrefundby, Set ismpotsByPotcndbillcountry, Set ismpotsByPotcndretreason, Set ismpotsByPotcndcanrefreason, Set ismpotsByPotcndleadsource, Set ismpotsByPotcndcanrefreson, Set ismpotsByPotcndcancreason, Set ismpotsByPotcndrtotype, Set ismpotsByPotcndbillstate, Set ismpotsByPotcndcardtype, Set ismpotsByPotcndcanrefinstracc, Set ismpotsByPotcndinitiatedby, Set ismpotsBypotbillcityrfnum, Set ismsdtsBySdtcndcountry, Set ismsdtsBySdtcndstate, Set ismsdtsBySdtcndcity, Set ismbpms, Set crmcptsByCptcnddispositiontype, Set crmcptsByCptcndcasetype, Set crmpcmsByPcmcndstate, Set crmpcmsByPcmcndcity, Set ismafmsByAfmcndbusinessid, Set ismafmsByAfmcndchannelid, Set ismscts, Set ismpbisByPbicndpreprocess, Set ismpbisByPbicndchannelid, Set ismpbisByPbicndsdshipper, Set ismpbisByPbicndprodtype, Set ismpbisByPbicndwtunit, Set ismpbisByPbicndhlwunit, Set ismpbisByPbicndpftype, Set ismpbisByPbicndpfpostpro, Set ismpbisByPbicndpfexpunit, Set ismcczsByCczcndzip, Set ismcczsByCczcndcntry, Set ismcczsByCczcndcity, Set ismrlmsByRlmcndstaterfnum, Set ismrlmsByRlmcndcityrfnum, Set ismhlms, Set ismapms, Set ismzvmsByZvmcity, Set ismzvmsByZvmcndzip, Set ismstlsByStlcndreqrepinstrven, Set ismstlsByStlreason11cnd, Set ismstlsByStlcndtobeverreason, Set ismstlsByStlcndpayproc, Set ismstlsByStlcndcanrefinstracc, Set ismstlsByStlcndinitiatedby, Set ismstlsByStlcndcanrefreason, Set ismstlsByStlcndrefreason, Set ismstlsByStlcndchqnotclrrea, Set ismstlsByStlcndcancreason, Set ismstlsByStlcndpaynotproc, Set ismstlsByStlcndemioptions, Set ismstlsByStlchknbnkdrescnd, Set ismstlsByStlcndcanrefreson, Set ismstlsByStlcndaltcntry, Set ismstlsByStlcndalttitle, Set ismstlsByStlcndchqreqinstracc, Set ismstlsByStlcndreqrepreason, Set ismstlsByStlcndtobeverinstrcrm, Set ismstlsByStlcndaltcity, Set ismstlsByStlcndacccanref, Set ismstlsByStlreason12cnd, Set ismstlsByStlcndsalretreason, Set ismstlsByStlchkundclrrescnd, Set ismstlsByStlretreson, Set ismstlsByStlcndaltstate, Set ismstlsByStlcndsalretinstracc, Set ismstlsByStlcndrefundby, Set ismstlsByStlcndrtotype, Set ismstlsByStlcndsalretinstrven, Set ismstlsByStlcndrefinstracc, Set ismpstsByPstcndtobeverinstrcrm, Set ismpstsByPstcndsalretinstracc, Set ismpstsByPstcndreqrepinstrven, Set ismpstsByPstcndcanrefreson, Set ismpstsByPstcndrefinstracc, Set ismpstsByPstcndinitiatedby, Set ismpstsByPstcndrefreason, Set ismpstsByPstcndrtotype, Set ismpstsByPstcndrecvcity, Set ismpstsByPstcndpaynotproc, Set ismpstsByPstcndretreason, Set ismpstsByPstcndemioptions, Set ismpstsByPstreason11cnd, Set ismpstsByPstcndsalretreason, Set ismpstsByPstsalereturn, Set ismpstsByPstcndpftype, Set ismpstsByPstreason12cnd, Set ismpstsByPstcndmercountry, Set ismpstsByPstcndpayproc, Set ismpstsByPstcndrecvcountry, Set ismpstsByPstchknbnkdrescnd, Set ismpstsByPstcndalttitle, Set ismpstsByPstcndmerstate, Set ismpstsByPstcndpostprocess, Set ismpstsByPstcndrecvstate, Set ismpstsByPstcndchqnotclrrea, Set ismpstsByPstcndpreprocess, Set ismpstsByPstcndtobeverreason, Set ismpstsByPstcndchannelid, Set ismpstsByPstcndaltstate, Set ismpstsByPstcndcanrefinstracc, Set ismpstsByPstcndaltcity, Set ismpstsByPstchkundclrrescnd, Set ismpstsByPstcndacccanref, Set ismpstsByPstcndreqrepreason, Set ismpstsByPstcndaltcntry, Set ismpstsByPstcndrefundby, Set ismpstsByPstcndcanrefreason, Set ismpstsByPstcndchqreqinstracc, Set ismpstsByPstcndsalretinstrven, Set ismpstsByPstcndcancreason, Set ismpstsByPstcndmercity, Set ismbsisByBsicndmaristat, Set ismbsisByBsicndhouseincm, Set ismbsisByBsicndeducation, Set ismbsisByBsicndoccupation, Set ismidcs, Set ismdats, Set octueasByUeacndoccur, Set octueasByUeacndevent, Set ismaprsByAprcndtype, Set ismaprsByAprcndelement, Set ismpilsByPilcndshiptype, Set ismpilsByPilcndpricetype, Set ismpilsByPilcndinvnttype, Set crmcttsByCttcndtodispositiontype, Set crmcttsByCttcndfeedbacktype, Set crmcttsByCttcndcaseassignto, Set crmcttsByCttcnddispositiontype, Set crmcttsByCttcndcasetype, Set ismsclsBySclcndhlwunit, Set ismsclsBySclcndwunit, Set ismsmls, Set ismssisBySsicndSla,String cndvalue) {
        this.cndcode = cndcode;
        this.cnddesc = cnddesc;
        this.cndgroup = cndgroup;
        this.createdate = createdate;
        this.createdby = createdby;
        this.deleted = deleted;
        this.modidate = modidate;
        this.ismcnd = ismcnd;
//        this.crmcfasByCfacndcasetype = crmcfasByCfacndcasetype;
//        this.crmcfasByCfacndfeedbacktype = crmcfasByCfacndfeedbacktype;
//        this.crmcfasByCfacndassignto = crmcfasByCfacndassignto;
//        this.ismidas = ismidas;
        this.ismcrpsByCrpcndbatchtype = ismcrpsByCrpcndbatchtype;
        this.ismcrpsByCrpcndremark = ismcrpsByCrpcndremark;
        this.ismcrpsByCrpcndreason = ismcrpsByCrpcndreason;
//        this.ismprts = ismprts;
//        this.crmlhtsByLhtcndresotype = crmlhtsByLhtcndresotype;
//        this.crmlhtsByLhtcndleadsource = crmlhtsByLhtcndleadsource;
//        this.crmlhtsByLhtcndzip = crmlhtsByLhtcndzip;
//        this.crmlhtsByLhtcndfeedbacktype = crmlhtsByLhtcndfeedbacktype;
//        this.crmlhtsByLhtcndleadtype = crmlhtsByLhtcndleadtype;
//        this.crmlhtsByLhtcndcity = crmlhtsByLhtcndcity;
//        this.crmlhtsByLhtcndstate = crmlhtsByLhtcndstate;
        this.ismsems = ismsems;
        this.ismlnfsByLnfcndopt = ismlnfsByLnfcndopt;
        this.ismlnfsByLnfcndent = ismlnfsByLnfcndent;
        this.ismlnfsByLnfcnddel = ismlnfsByLnfcnddel;
//        this.ismrpts = ismrpts;
//        this.crmcdtsByCdtcndtodispositiontype = crmcdtsByCdtcndtodispositiontype;
//        this.crmcdtsByCdtcnddispositiontype = crmcdtsByCdtcnddispositiontype;
//        this.crmcdtsByCdtcndcasetype = crmcdtsByCdtcndcasetype;
        this.ismppms = ismppms;
        this.ismrdts = ismrdts;
//        this.ismuatsByUatcndtitle = ismuatsByUatcndtitle;
//        this.ismuatsByUatcndcountry = ismuatsByUatcndcountry;
//        this.ismuatsByUatcndcity = ismuatsByUatcndcity;
//        this.ismuatsByUatcndstate = ismuatsByUatcndstate;
        this.ismemls = ismemls;
        this.ismsdcs = ismsdcs;
//        this.ismpdts = ismpdts;
        this.ismidmsByIdmcndname = ismidmsByIdmcndname;
        this.ismidmsByIdmcndprotocol = ismidmsByIdmcndprotocol;
        this.ismmccs = ismmccs;
        this.ismpcos = ismpcos;
        this.ismpfis = ismpfis;
        this.ismubis = ismubis;
//        this.ismssisBySsicndtitle = ismssisBySsicndtitle;
//        this.ismssisBySsicndvendortype = ismssisBySsicndvendortype;
//        this.ismssisBySsicndstaffstrgnth = ismssisBySsicndstaffstrgnth;
//        this.ismssisBySsicndannualto = ismssisBySsicndannualto;
        this.octapps = octapps;
        this.ismcnds = ismcnds;
        this.octiatsByIatcndbusid = octiatsByIatcndbusid;
        this.octiatsByIatcndchannelid = octiatsByIatcndchannelid;
//        this.ismotlsByOtlcndcanrefinstracc = ismotlsByOtlcndcanrefinstracc;
//        this.ismotlsByOtlcndrtotype = ismotlsByOtlcndrtotype;
//        this.ismotlsByOtlcndaltcity = ismotlsByOtlcndaltcity;
//        this.ismotlsByOtlcndemioptions = ismotlsByOtlcndemioptions;
//        this.ismotlsByOtlcndaltcntry = ismotlsByOtlcndaltcntry;
//        this.ismotlsByOtlcndcanrefreason = ismotlsByOtlcndcanrefreason;
//        this.ismotlsByOtlcndcancreason = ismotlsByOtlcndcancreason;
//        this.ismotlsByOtlcndretreason = ismotlsByOtlcndretreason;
//        this.ismotlsByOtlcndrefreason = ismotlsByOtlcndrefreason;
//        this.ismotlsByOtlcndcanrefreson = ismotlsByOtlcndcanrefreson;
//        this.ismotlsByOtlcndaltstate = ismotlsByOtlcndaltstate;
//        this.ismotlsByOtlcndinitiatedby = ismotlsByOtlcndinitiatedby;
//        this.ismotlsByOtlcndrefundby = ismotlsByOtlcndrefundby;
        this.ismoems = ismoems;
//        this.ismccdsByCcdcndlocidcity = ismccdsByCcdcndlocidcity;
//        this.ismccdsByCcdcndstate = ismccdsByCcdcndstate;
//        this.ismccdsByCcdcndcity = ismccdsByCcdcndcity;
//        this.ismccdsByCcdcndcountry = ismccdsByCcdcndcountry;
        this.ismpmts = ismpmts;
        this.ismdpps = ismdpps;
//        this.ismpotsByPotbusinessid = ismpotsByPotbusinessid;
//        this.ismpotsByPotpaymodetype = ismpotsByPotpaymodetype;
//        this.ismpotsByPotcndemioptions = ismpotsByPotcndemioptions;
//        this.ismpotsByPotcndrefreason = ismpotsByPotcndrefreason;
//        this.ismpotsByPotcndrefundby = ismpotsByPotcndrefundby;
//        this.ismpotsByPotcndbillcountry = ismpotsByPotcndbillcountry;
//        this.ismpotsByPotcndretreason = ismpotsByPotcndretreason;
//        this.ismpotsByPotcndcanrefreason = ismpotsByPotcndcanrefreason;
//        this.ismpotsByPotcndleadsource = ismpotsByPotcndleadsource;
//        this.ismpotsByPotcndcanrefreson = ismpotsByPotcndcanrefreson;
//        this.ismpotsByPotcndcancreason = ismpotsByPotcndcancreason;
//        this.ismpotsByPotcndrtotype = ismpotsByPotcndrtotype;
//        this.ismpotsByPotcndbillstate = ismpotsByPotcndbillstate;
//        this.ismpotsByPotcndcardtype = ismpotsByPotcndcardtype;
//        this.ismpotsByPotcndcanrefinstracc = ismpotsByPotcndcanrefinstracc;
//        this.ismpotsByPotcndinitiatedby = ismpotsByPotcndinitiatedby;
//        this.ismpotsBypotbillcityrfnum = ismpotsBypotbillcityrfnum;
//        this.ismsdtsBySdtcndcountry = ismsdtsBySdtcndcountry;
//        this.ismsdtsBySdtcndstate = ismsdtsBySdtcndstate;
//        this.ismsdtsBySdtcndcity = ismsdtsBySdtcndcity;
        this.ismbpms = ismbpms;
//        this.crmcptsByCptcnddispositiontype = crmcptsByCptcnddispositiontype;
//        this.crmcptsByCptcndcasetype = crmcptsByCptcndcasetype;
//        this.crmpcmsByPcmcndstate = crmpcmsByPcmcndstate;
//        this.crmpcmsByPcmcndcity = crmpcmsByPcmcndcity;
        this.ismafmsByAfmcndbusinessid = ismafmsByAfmcndbusinessid;
        this.ismafmsByAfmcndchannelid = ismafmsByAfmcndchannelid;
        this.ismscts = ismscts;
//        this.ismpbisByPbicndpreprocess = ismpbisByPbicndpreprocess;
//        this.ismpbisByPbicndchannelid = ismpbisByPbicndchannelid;
//        this.ismpbisByPbicndsdshipper = ismpbisByPbicndsdshipper;
//        this.ismpbisByPbicndprodtype = ismpbisByPbicndprodtype;
//        this.ismpbisByPbicndwtunit = ismpbisByPbicndwtunit;
//        this.ismpbisByPbicndhlwunit = ismpbisByPbicndhlwunit;
//        this.ismpbisByPbicndpftype = ismpbisByPbicndpftype;
//        this.ismpbisByPbicndpfpostpro = ismpbisByPbicndpfpostpro;
//        this.ismpbisByPbicndpfexpunit = ismpbisByPbicndpfexpunit;
        this.ismcczsByCczcndzip = ismcczsByCczcndzip;
        this.ismcczsByCczcndcntry = ismcczsByCczcndcntry;
        this.ismcczsByCczcndcity = ismcczsByCczcndcity;
//        this.ismrlmsByRlmcndstaterfnum = ismrlmsByRlmcndstaterfnum;
//        this.ismrlmsByRlmcndcityrfnum = ismrlmsByRlmcndcityrfnum;
        this.ismhlms = ismhlms;
        this.ismapms = ismapms;
        this.ismzvmsByZvmcity = ismzvmsByZvmcity;
        this.ismzvmsByZvmcndzip = ismzvmsByZvmcndzip;
//        this.ismstlsByStlcndreqrepinstrven = ismstlsByStlcndreqrepinstrven;
//        this.ismstlsByStlreason11cnd = ismstlsByStlreason11cnd;
//        this.ismstlsByStlcndtobeverreason = ismstlsByStlcndtobeverreason;
//        this.ismstlsByStlcndpayproc = ismstlsByStlcndpayproc;
//        this.ismstlsByStlcndcanrefinstracc = ismstlsByStlcndcanrefinstracc;
//        this.ismstlsByStlcndinitiatedby = ismstlsByStlcndinitiatedby;
//        this.ismstlsByStlcndcanrefreason = ismstlsByStlcndcanrefreason;
//        this.ismstlsByStlcndrefreason = ismstlsByStlcndrefreason;
//        this.ismstlsByStlcndchqnotclrrea = ismstlsByStlcndchqnotclrrea;
//        this.ismstlsByStlcndcancreason = ismstlsByStlcndcancreason;
//        this.ismstlsByStlcndpaynotproc = ismstlsByStlcndpaynotproc;
//        this.ismstlsByStlcndemioptions = ismstlsByStlcndemioptions;
//        this.ismstlsByStlchknbnkdrescnd = ismstlsByStlchknbnkdrescnd;
//        this.ismstlsByStlcndcanrefreson = ismstlsByStlcndcanrefreson;
//        this.ismstlsByStlcndaltcntry = ismstlsByStlcndaltcntry;
//        this.ismstlsByStlcndalttitle = ismstlsByStlcndalttitle;
//        this.ismstlsByStlcndchqreqinstracc = ismstlsByStlcndchqreqinstracc;
//        this.ismstlsByStlcndreqrepreason = ismstlsByStlcndreqrepreason;
//        this.ismstlsByStlcndtobeverinstrcrm = ismstlsByStlcndtobeverinstrcrm;
//        this.ismstlsByStlcndaltcity = ismstlsByStlcndaltcity;
//        this.ismstlsByStlcndacccanref = ismstlsByStlcndacccanref;
//        this.ismstlsByStlreason12cnd = ismstlsByStlreason12cnd;
//        this.ismstlsByStlcndsalretreason = ismstlsByStlcndsalretreason;
//        this.ismstlsByStlchkundclrrescnd = ismstlsByStlchkundclrrescnd;
//        this.ismstlsByStlretreson = ismstlsByStlretreson;
//        this.ismstlsByStlcndaltstate = ismstlsByStlcndaltstate;
//        this.ismstlsByStlcndsalretinstracc = ismstlsByStlcndsalretinstracc;
//        this.ismstlsByStlcndrefundby = ismstlsByStlcndrefundby;
//        this.ismstlsByStlcndrtotype = ismstlsByStlcndrtotype;
//        this.ismstlsByStlcndsalretinstrven = ismstlsByStlcndsalretinstrven;
//        this.ismstlsByStlcndrefinstracc = ismstlsByStlcndrefinstracc;
//        this.ismpstsByPstcndtobeverinstrcrm = ismpstsByPstcndtobeverinstrcrm;
//        this.ismpstsByPstcndsalretinstracc = ismpstsByPstcndsalretinstracc;
//        this.ismpstsByPstcndreqrepinstrven = ismpstsByPstcndreqrepinstrven;
//        this.ismpstsByPstcndcanrefreson = ismpstsByPstcndcanrefreson;
//        this.ismpstsByPstcndrefinstracc = ismpstsByPstcndrefinstracc;
//        this.ismpstsByPstcndinitiatedby = ismpstsByPstcndinitiatedby;
//        this.ismpstsByPstcndrefreason = ismpstsByPstcndrefreason;
//        this.ismpstsByPstcndrtotype = ismpstsByPstcndrtotype;
//        this.ismpstsByPstcndrecvcity = ismpstsByPstcndrecvcity;
//        this.ismpstsByPstcndpaynotproc = ismpstsByPstcndpaynotproc;
//        this.ismpstsByPstcndretreason = ismpstsByPstcndretreason;
//        this.ismpstsByPstcndemioptions = ismpstsByPstcndemioptions;
//        this.ismpstsByPstreason11cnd = ismpstsByPstreason11cnd;
//        this.ismpstsByPstcndsalretreason = ismpstsByPstcndsalretreason;
//        this.ismpstsByPstsalereturn = ismpstsByPstsalereturn;
//        this.ismpstsByPstcndpftype = ismpstsByPstcndpftype;
//        this.ismpstsByPstreason12cnd = ismpstsByPstreason12cnd;
//        this.ismpstsByPstcndmercountry = ismpstsByPstcndmercountry;
//        this.ismpstsByPstcndpayproc = ismpstsByPstcndpayproc;
//        this.ismpstsByPstcndrecvcountry = ismpstsByPstcndrecvcountry;
//        this.ismpstsByPstchknbnkdrescnd = ismpstsByPstchknbnkdrescnd;
//        this.ismpstsByPstcndalttitle = ismpstsByPstcndalttitle;
//        this.ismpstsByPstcndmerstate = ismpstsByPstcndmerstate;
//        this.ismpstsByPstcndpostprocess = ismpstsByPstcndpostprocess;
//        this.ismpstsByPstcndrecvstate = ismpstsByPstcndrecvstate;
//        this.ismpstsByPstcndchqnotclrrea = ismpstsByPstcndchqnotclrrea;
//        this.ismpstsByPstcndpreprocess = ismpstsByPstcndpreprocess;
//        this.ismpstsByPstcndtobeverreason = ismpstsByPstcndtobeverreason;
//        this.ismpstsByPstcndchannelid = ismpstsByPstcndchannelid;
//        this.ismpstsByPstcndaltstate = ismpstsByPstcndaltstate;
//        this.ismpstsByPstcndcanrefinstracc = ismpstsByPstcndcanrefinstracc;
//        this.ismpstsByPstcndaltcity = ismpstsByPstcndaltcity;
//        this.ismpstsByPstchkundclrrescnd = ismpstsByPstchkundclrrescnd;
//        this.ismpstsByPstcndacccanref = ismpstsByPstcndacccanref;
//        this.ismpstsByPstcndreqrepreason = ismpstsByPstcndreqrepreason;
//        this.ismpstsByPstcndaltcntry = ismpstsByPstcndaltcntry;
//        this.ismpstsByPstcndrefundby = ismpstsByPstcndrefundby;
//        this.ismpstsByPstcndcanrefreason = ismpstsByPstcndcanrefreason;
//        this.ismpstsByPstcndchqreqinstracc = ismpstsByPstcndchqreqinstracc;
//        this.ismpstsByPstcndsalretinstrven = ismpstsByPstcndsalretinstrven;
//        this.ismpstsByPstcndcancreason = ismpstsByPstcndcancreason;
//        this.ismpstsByPstcndmercity = ismpstsByPstcndmercity;
//        this.ismbsisByBsicndmaristat = ismbsisByBsicndmaristat;
//        this.ismbsisByBsicndhouseincm = ismbsisByBsicndhouseincm;
//        this.ismbsisByBsicndeducation = ismbsisByBsicndeducation;
//        this.ismbsisByBsicndoccupation = ismbsisByBsicndoccupation;
        this.ismidcs = ismidcs;
        this.ismdats = ismdats;
        this.octueasByUeacndoccur = octueasByUeacndoccur;
        this.octueasByUeacndevent = octueasByUeacndevent;
        this.ismaprsByAprcndtype = ismaprsByAprcndtype;
        this.ismaprsByAprcndelement = ismaprsByAprcndelement;
//        this.ismpilsByPilcndpricetype = ismpilsByPilcndpricetype;
//        this.ismpilsByPilcndinvnttype = ismpilsByPilcndinvnttype;
//        this.crmcttsByCttcndtodispositiontype = crmcttsByCttcndtodispositiontype;
//        this.crmcttsByCttcndfeedbacktype = crmcttsByCttcndfeedbacktype;
//        this.crmcttsByCttcndcaseassignto = crmcttsByCttcndcaseassignto;
//        this.crmcttsByCttcnddispositiontype = crmcttsByCttcnddispositiontype;
//        this.crmcttsByCttcndcasetype = crmcttsByCttcndcasetype;
//        this.ismsclsBySclcndhlwunit = ismsclsBySclcndhlwunit;
//        this.ismsclsBySclcndwunit = ismsclsBySclcndwunit;
        this.ismsmls = ismsmls;
//        this.ismssisBySsicndSla = ismssisBySsicndSla;
        this.cndvalue = cndvalue;
    }

    /** default constructor */
    public Ismcnd() {
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getCndrfnum() {
        return this.cndrfnum;
    }

    public void setCndrfnum(Long cndrfnum) {
        this.cndrfnum = cndrfnum;
    }

    public String getCndcode() {
        return this.cndcode;
    }

    public void setCndcode(String cndcode) {
        this.cndcode = cndcode;
    }

    public String getCnddesc() {
        return this.cnddesc;
    }

    public void setCnddesc(String cnddesc) {
        this.cnddesc = cnddesc;
    }

    public String getCndgroup() {
        return this.cndgroup;
    }

    public void setCndgroup(String cndgroup) {
        this.cndgroup = cndgroup;
    }

    public Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Long getCreatedby() {
        return this.createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public String getDeleted() {
        return this.deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Date getModidate() {
        return this.modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public com.sellerportal.model.Ismcnd getIsmcnd() {
        return this.ismcnd;
    }

    public void setIsmcnd(com.sellerportal.model.Ismcnd ismcnd) {
        this.ismcnd = ismcnd;
    }

//    public Set getCrmcfasByCfacndcasetype() {
//        return this.crmcfasByCfacndcasetype;
//    }

//    public void setCrmcfasByCfacndcasetype(Set crmcfasByCfacndcasetype) {
//        this.crmcfasByCfacndcasetype = crmcfasByCfacndcasetype;
//    }

//    public Set getCrmcfasByCfacndfeedbacktype() {
//        return this.crmcfasByCfacndfeedbacktype;
//    }
//
//    public void setCrmcfasByCfacndfeedbacktype(Set crmcfasByCfacndfeedbacktype) {
//        this.crmcfasByCfacndfeedbacktype = crmcfasByCfacndfeedbacktype;
//    }

//    public Set getCrmcfasByCfacndassignto() {
//        return this.crmcfasByCfacndassignto;
//    }
//
//    public void setCrmcfasByCfacndassignto(Set crmcfasByCfacndassignto) {
//        this.crmcfasByCfacndassignto = crmcfasByCfacndassignto;
//    }

//    public Set getIsmidas() {
//        return this.ismidas;
//    }

//    public void setIsmidas(Set ismidas) {
//        this.ismidas = ismidas;
//    }

    public Set getIsmcrpsByCrpcndbatchtype() {
        return this.ismcrpsByCrpcndbatchtype;
    }

    public void setIsmcrpsByCrpcndbatchtype(Set ismcrpsByCrpcndbatchtype) {
        this.ismcrpsByCrpcndbatchtype = ismcrpsByCrpcndbatchtype;
    }

    public Set getIsmcrpsByCrpcndremark() {
        return this.ismcrpsByCrpcndremark;
    }

    public void setIsmcrpsByCrpcndremark(Set ismcrpsByCrpcndremark) {
        this.ismcrpsByCrpcndremark = ismcrpsByCrpcndremark;
    }

    public Set getIsmcrpsByCrpcndreason() {
        return this.ismcrpsByCrpcndreason;
    }

    public void setIsmcrpsByCrpcndreason(Set ismcrpsByCrpcndreason) {
        this.ismcrpsByCrpcndreason = ismcrpsByCrpcndreason;
    }

//    public Set getIsmprts() {
//        return this.ismprts;
//    }
//
//    public void setIsmprts(Set ismprts) {
//        this.ismprts = ismprts;
//    }
//
//    public Set getCrmlhtsByLhtcndresotype() {
//        return this.crmlhtsByLhtcndresotype;
//    }
//
//    public void setCrmlhtsByLhtcndresotype(Set crmlhtsByLhtcndresotype) {
//        this.crmlhtsByLhtcndresotype = crmlhtsByLhtcndresotype;
//    }
//
//    public Set getCrmlhtsByLhtcndleadsource() {
//        return this.crmlhtsByLhtcndleadsource;
//    }
//
//    public void setCrmlhtsByLhtcndleadsource(Set crmlhtsByLhtcndleadsource) {
//        this.crmlhtsByLhtcndleadsource = crmlhtsByLhtcndleadsource;
//    }
//
//    public Set getCrmlhtsByLhtcndzip() {
//        return this.crmlhtsByLhtcndzip;
//    }
//
//    public void setCrmlhtsByLhtcndzip(Set crmlhtsByLhtcndzip) {
//        this.crmlhtsByLhtcndzip = crmlhtsByLhtcndzip;
//    }
//
//    public Set getCrmlhtsByLhtcndfeedbacktype() {
//        return this.crmlhtsByLhtcndfeedbacktype;
//    }
//
//    public void setCrmlhtsByLhtcndfeedbacktype(Set crmlhtsByLhtcndfeedbacktype) {
//        this.crmlhtsByLhtcndfeedbacktype = crmlhtsByLhtcndfeedbacktype;
//    }
//
//    public Set getCrmlhtsByLhtcndleadtype() {
//        return this.crmlhtsByLhtcndleadtype;
//    }
//
//    public void setCrmlhtsByLhtcndleadtype(Set crmlhtsByLhtcndleadtype) {
//        this.crmlhtsByLhtcndleadtype = crmlhtsByLhtcndleadtype;
//    }
//
//    public Set getCrmlhtsByLhtcndcity() {
//        return this.crmlhtsByLhtcndcity;
//    }
//
//    public void setCrmlhtsByLhtcndcity(Set crmlhtsByLhtcndcity) {
//        this.crmlhtsByLhtcndcity = crmlhtsByLhtcndcity;
//    }
//
//    public Set getCrmlhtsByLhtcndstate() {
//        return this.crmlhtsByLhtcndstate;
//    }
//
//    public void setCrmlhtsByLhtcndstate(Set crmlhtsByLhtcndstate) {
//        this.crmlhtsByLhtcndstate = crmlhtsByLhtcndstate;
//    }

    public Set getIsmsems() {
        return this.ismsems;
    }

    public void setIsmsems(Set ismsems) {
        this.ismsems = ismsems;
    }

    public Set getIsmlnfsByLnfcndopt() {
        return this.ismlnfsByLnfcndopt;
    }

    public void setIsmlnfsByLnfcndopt(Set ismlnfsByLnfcndopt) {
        this.ismlnfsByLnfcndopt = ismlnfsByLnfcndopt;
    }

    public Set getIsmlnfsByLnfcndent() {
        return this.ismlnfsByLnfcndent;
    }

    public void setIsmlnfsByLnfcndent(Set ismlnfsByLnfcndent) {
        this.ismlnfsByLnfcndent = ismlnfsByLnfcndent;
    }

    public Set getIsmlnfsByLnfcnddel() {
        return this.ismlnfsByLnfcnddel;
    }

    public void setIsmlnfsByLnfcnddel(Set ismlnfsByLnfcnddel) {
        this.ismlnfsByLnfcnddel = ismlnfsByLnfcnddel;
    }

//    public Set getIsmrpts() {
//        return this.ismrpts;
//    }
//
//    public void setIsmrpts(Set ismrpts) {
//        this.ismrpts = ismrpts;
//    }

//    public Set getCrmcdtsByCdtcndtodispositiontype() {
//        return this.crmcdtsByCdtcndtodispositiontype;
//    }
//
//    public void setCrmcdtsByCdtcndtodispositiontype(Set crmcdtsByCdtcndtodispositiontype) {
//        this.crmcdtsByCdtcndtodispositiontype = crmcdtsByCdtcndtodispositiontype;
//    }

//    public Set getCrmcdtsByCdtcnddispositiontype() {
//        return this.crmcdtsByCdtcnddispositiontype;
//    }
//
//    public void setCrmcdtsByCdtcnddispositiontype(Set crmcdtsByCdtcnddispositiontype) {
//        this.crmcdtsByCdtcnddispositiontype = crmcdtsByCdtcnddispositiontype;
//    }
//
//    public Set getCrmcdtsByCdtcndcasetype() {
//        return this.crmcdtsByCdtcndcasetype;
//    }

//    public void setCrmcdtsByCdtcndcasetype(Set crmcdtsByCdtcndcasetype) {
//        this.crmcdtsByCdtcndcasetype = crmcdtsByCdtcndcasetype;
//    }

    public Set getIsmppms() {
        return this.ismppms;
    }

    public void setIsmppms(Set ismppms) {
        this.ismppms = ismppms;
    }

    public Set getIsmrdts() {
        return this.ismrdts;
    }

    public void setIsmrdts(Set ismrdts) {
        this.ismrdts = ismrdts;
    }

//    public Set getIsmuatsByUatcndtitle() {
//        return this.ismuatsByUatcndtitle;
//    }
//
//    public void setIsmuatsByUatcndtitle(Set ismuatsByUatcndtitle) {
//        this.ismuatsByUatcndtitle = ismuatsByUatcndtitle;
//    }

//    public Set getIsmuatsByUatcndcountry() {
//        return this.ismuatsByUatcndcountry;
//    }
//
//    public void setIsmuatsByUatcndcountry(Set ismuatsByUatcndcountry) {
//        this.ismuatsByUatcndcountry = ismuatsByUatcndcountry;
//    }
//
//    public Set getIsmuatsByUatcndcity() {
//        return this.ismuatsByUatcndcity;
//    }
//
//    public void setIsmuatsByUatcndcity(Set ismuatsByUatcndcity) {
//        this.ismuatsByUatcndcity = ismuatsByUatcndcity;
//    }
//
//    public Set getIsmuatsByUatcndstate() {
//        return this.ismuatsByUatcndstate;
//    }
//
//    public void setIsmuatsByUatcndstate(Set ismuatsByUatcndstate) {
//        this.ismuatsByUatcndstate = ismuatsByUatcndstate;
//    }

    public Set getIsmemls() {
        return this.ismemls;
    }

    public void setIsmemls(Set ismemls) {
        this.ismemls = ismemls;
    }

    public Set getIsmsdcs() {
        return this.ismsdcs;
    }

    public void setIsmsdcs(Set ismsdcs) {
        this.ismsdcs = ismsdcs;
    }

//    public Set getIsmpdts() {
//        return this.ismpdts;
//    }
//
//    public void setIsmpdts(Set ismpdts) {
//        this.ismpdts = ismpdts;
//    }

    public Set getIsmidmsByIdmcndname() {
        return this.ismidmsByIdmcndname;
    }

    public void setIsmidmsByIdmcndname(Set ismidmsByIdmcndname) {
        this.ismidmsByIdmcndname = ismidmsByIdmcndname;
    }

    public Set getIsmidmsByIdmcndprotocol() {
        return this.ismidmsByIdmcndprotocol;
    }

    public void setIsmidmsByIdmcndprotocol(Set ismidmsByIdmcndprotocol) {
        this.ismidmsByIdmcndprotocol = ismidmsByIdmcndprotocol;
    }

    public Set getIsmmccs() {
        return this.ismmccs;
    }

    public void setIsmmccs(Set ismmccs) {
        this.ismmccs = ismmccs;
    }

    public Set getIsmpcos() {
        return this.ismpcos;
    }

    public void setIsmpcos(Set ismpcos) {
        this.ismpcos = ismpcos;
    }

    public Set getIsmpfis() {
        return this.ismpfis;
    }

    public void setIsmpfis(Set ismpfis) {
        this.ismpfis = ismpfis;
    }

    public Set getIsmubis() {
        return this.ismubis;
    }

    public void setIsmubis(Set ismubis) {
        this.ismubis = ismubis;
    }

//    public Set getIsmssisBySsicndtitle() {
//        return this.ismssisBySsicndtitle;
//    }
//
//    public void setIsmssisBySsicndtitle(Set ismssisBySsicndtitle) {
//        this.ismssisBySsicndtitle = ismssisBySsicndtitle;
//    }
//
//    public Set getIsmssisBySsicndvendortype() {
//        return this.ismssisBySsicndvendortype;
//    }
//
//    public void setIsmssisBySsicndvendortype(Set ismssisBySsicndvendortype) {
//        this.ismssisBySsicndvendortype = ismssisBySsicndvendortype;
//    }
//
//    public Set getIsmssisBySsicndstaffstrgnth() {
//        return this.ismssisBySsicndstaffstrgnth;
//    }
//
//    public void setIsmssisBySsicndstaffstrgnth(Set ismssisBySsicndstaffstrgnth) {
//        this.ismssisBySsicndstaffstrgnth = ismssisBySsicndstaffstrgnth;
//    }
//
//    public Set getIsmssisBySsicndannualto() {
//        return this.ismssisBySsicndannualto;
//    }
//
//    public void setIsmssisBySsicndannualto(Set ismssisBySsicndannualto) {
//        this.ismssisBySsicndannualto = ismssisBySsicndannualto;
//    }

    public Set getOctapps() {
        return this.octapps;
    }

    public void setOctapps(Set octapps) {
        this.octapps = octapps;
    }

    public Set getIsmcnds() {
        return this.ismcnds;
    }

    public void setIsmcnds(Set ismcnds) {
        this.ismcnds = ismcnds;
    }

    public Set getOctiatsByIatcndbusid() {
        return this.octiatsByIatcndbusid;
    }

    public void setOctiatsByIatcndbusid(Set octiatsByIatcndbusid) {
        this.octiatsByIatcndbusid = octiatsByIatcndbusid;
    }

    public Set getOctiatsByIatcndchannelid() {
        return this.octiatsByIatcndchannelid;
    }

    public void setOctiatsByIatcndchannelid(Set octiatsByIatcndchannelid) {
        this.octiatsByIatcndchannelid = octiatsByIatcndchannelid;
    }

//    public Set getIsmotlsByOtlcndcanrefinstracc() {
//        return this.ismotlsByOtlcndcanrefinstracc;
//    }
//
//    public void setIsmotlsByOtlcndcanrefinstracc(Set ismotlsByOtlcndcanrefinstracc) {
//        this.ismotlsByOtlcndcanrefinstracc = ismotlsByOtlcndcanrefinstracc;
//    }
//
//    public Set getIsmotlsByOtlcndrtotype() {
//        return this.ismotlsByOtlcndrtotype;
//    }
//
//    public void setIsmotlsByOtlcndrtotype(Set ismotlsByOtlcndrtotype) {
//        this.ismotlsByOtlcndrtotype = ismotlsByOtlcndrtotype;
//    }
//
//    public Set getIsmotlsByOtlcndaltcity() {
//        return this.ismotlsByOtlcndaltcity;
//    }
//
//    public void setIsmotlsByOtlcndaltcity(Set ismotlsByOtlcndaltcity) {
//        this.ismotlsByOtlcndaltcity = ismotlsByOtlcndaltcity;
//    }
//
//    public Set getIsmotlsByOtlcndemioptions() {
//        return this.ismotlsByOtlcndemioptions;
//    }
//
//    public void setIsmotlsByOtlcndemioptions(Set ismotlsByOtlcndemioptions) {
//        this.ismotlsByOtlcndemioptions = ismotlsByOtlcndemioptions;
//    }
//
//    public Set getIsmotlsByOtlcndaltcntry() {
//        return this.ismotlsByOtlcndaltcntry;
//    }
//
//    public void setIsmotlsByOtlcndaltcntry(Set ismotlsByOtlcndaltcntry) {
//        this.ismotlsByOtlcndaltcntry = ismotlsByOtlcndaltcntry;
//    }
//
//    public Set getIsmotlsByOtlcndcanrefreason() {
//        return this.ismotlsByOtlcndcanrefreason;
//    }
//
//    public void setIsmotlsByOtlcndcanrefreason(Set ismotlsByOtlcndcanrefreason) {
//        this.ismotlsByOtlcndcanrefreason = ismotlsByOtlcndcanrefreason;
//    }
//
//    public Set getIsmotlsByOtlcndcancreason() {
//        return this.ismotlsByOtlcndcancreason;
//    }
//
//    public void setIsmotlsByOtlcndcancreason(Set ismotlsByOtlcndcancreason) {
//        this.ismotlsByOtlcndcancreason = ismotlsByOtlcndcancreason;
//    }
//
//    public Set getIsmotlsByOtlcndretreason() {
//        return this.ismotlsByOtlcndretreason;
//    }
//
//    public void setIsmotlsByOtlcndretreason(Set ismotlsByOtlcndretreason) {
//        this.ismotlsByOtlcndretreason = ismotlsByOtlcndretreason;
//    }
//
//    public Set getIsmotlsByOtlcndrefreason() {
//        return this.ismotlsByOtlcndrefreason;
//    }
//
//    public void setIsmotlsByOtlcndrefreason(Set ismotlsByOtlcndrefreason) {
//        this.ismotlsByOtlcndrefreason = ismotlsByOtlcndrefreason;
//    }
//
//    public Set getIsmotlsByOtlcndcanrefreson() {
//        return this.ismotlsByOtlcndcanrefreson;
//    }
//
//    public void setIsmotlsByOtlcndcanrefreson(Set ismotlsByOtlcndcanrefreson) {
//        this.ismotlsByOtlcndcanrefreson = ismotlsByOtlcndcanrefreson;
//    }
//
//    public Set getIsmotlsByOtlcndaltstate() {
//        return this.ismotlsByOtlcndaltstate;
//    }
//
//    public void setIsmotlsByOtlcndaltstate(Set ismotlsByOtlcndaltstate) {
//        this.ismotlsByOtlcndaltstate = ismotlsByOtlcndaltstate;
//    }
//
//    public Set getIsmotlsByOtlcndinitiatedby() {
//        return this.ismotlsByOtlcndinitiatedby;
//    }
//
//    public void setIsmotlsByOtlcndinitiatedby(Set ismotlsByOtlcndinitiatedby) {
//        this.ismotlsByOtlcndinitiatedby = ismotlsByOtlcndinitiatedby;
//    }
//
//    public Set getIsmotlsByOtlcndrefundby() {
//        return this.ismotlsByOtlcndrefundby;
//    }
//
//    public void setIsmotlsByOtlcndrefundby(Set ismotlsByOtlcndrefundby) {
//        this.ismotlsByOtlcndrefundby = ismotlsByOtlcndrefundby;
//    }

    public Set getIsmoems() {
        return this.ismoems;
    }

    public void setIsmoems(Set ismoems) {
        this.ismoems = ismoems;
    }

//    public Set getIsmccdsByCcdcndlocidcity() {
//        return this.ismccdsByCcdcndlocidcity;
//    }
//
//    public void setIsmccdsByCcdcndlocidcity(Set ismccdsByCcdcndlocidcity) {
//        this.ismccdsByCcdcndlocidcity = ismccdsByCcdcndlocidcity;
//    }
//
//    public Set getIsmccdsByCcdcndstate() {
//        return this.ismccdsByCcdcndstate;
//    }
//
//    public void setIsmccdsByCcdcndstate(Set ismccdsByCcdcndstate) {
//        this.ismccdsByCcdcndstate = ismccdsByCcdcndstate;
//    }
//
//    public Set getIsmccdsByCcdcndcity() {
//        return this.ismccdsByCcdcndcity;
//    }
//
//    public void setIsmccdsByCcdcndcity(Set ismccdsByCcdcndcity) {
//        this.ismccdsByCcdcndcity = ismccdsByCcdcndcity;
//    }
//
//    public Set getIsmccdsByCcdcndcountry() {
//        return this.ismccdsByCcdcndcountry;
//    }
//
//    public void setIsmccdsByCcdcndcountry(Set ismccdsByCcdcndcountry) {
//        this.ismccdsByCcdcndcountry = ismccdsByCcdcndcountry;
//    }

    public Set getIsmpmts() {
        return this.ismpmts;
    }

    public void setIsmpmts(Set ismpmts) {
        this.ismpmts = ismpmts;
    }

    public Set getIsmdpps() {
        return this.ismdpps;
    }

    public void setIsmdpps(Set ismdpps) {
        this.ismdpps = ismdpps;
    }

//    public Set getIsmpotsByPotbusinessid() {
//        return this.ismpotsByPotbusinessid;
//    }
//
//    public void setIsmpotsByPotbusinessid(Set ismpotsByPotbusinessid) {
//        this.ismpotsByPotbusinessid = ismpotsByPotbusinessid;
//    }
//
//    public Set getIsmpotsByPotpaymodetype() {
//        return this.ismpotsByPotpaymodetype;
//    }
//
//    public void setIsmpotsByPotpaymodetype(Set ismpotsByPotpaymodetype) {
//        this.ismpotsByPotpaymodetype = ismpotsByPotpaymodetype;
//    }
//
//    public Set getIsmpotsByPotcndemioptions() {
//        return this.ismpotsByPotcndemioptions;
//    }
//
//    public void setIsmpotsByPotcndemioptions(Set ismpotsByPotcndemioptions) {
//        this.ismpotsByPotcndemioptions = ismpotsByPotcndemioptions;
//    }
//
//    public Set getIsmpotsByPotcndrefreason() {
//        return this.ismpotsByPotcndrefreason;
//    }
//
//    public void setIsmpotsByPotcndrefreason(Set ismpotsByPotcndrefreason) {
//        this.ismpotsByPotcndrefreason = ismpotsByPotcndrefreason;
//    }
//
//    public Set getIsmpotsByPotcndrefundby() {
//        return this.ismpotsByPotcndrefundby;
//    }
//
//    public void setIsmpotsByPotcndrefundby(Set ismpotsByPotcndrefundby) {
//        this.ismpotsByPotcndrefundby = ismpotsByPotcndrefundby;
//    }
//
//    public Set getIsmpotsByPotcndbillcountry() {
//        return this.ismpotsByPotcndbillcountry;
//    }
//
//    public void setIsmpotsByPotcndbillcountry(Set ismpotsByPotcndbillcountry) {
//        this.ismpotsByPotcndbillcountry = ismpotsByPotcndbillcountry;
//    }
//
//    public Set getIsmpotsByPotcndretreason() {
//        return this.ismpotsByPotcndretreason;
//    }
//
//    public void setIsmpotsByPotcndretreason(Set ismpotsByPotcndretreason) {
//        this.ismpotsByPotcndretreason = ismpotsByPotcndretreason;
//    }
//
//    public Set getIsmpotsByPotcndcanrefreason() {
//        return this.ismpotsByPotcndcanrefreason;
//    }
//
//    public void setIsmpotsByPotcndcanrefreason(Set ismpotsByPotcndcanrefreason) {
//        this.ismpotsByPotcndcanrefreason = ismpotsByPotcndcanrefreason;
//    }
//    
//    public Set getIsmpotsByPotcndleadsource() {
//        return this.ismpotsByPotcndleadsource;
//    }
//
//    public void setIsmpotsByPotcndleadsource(Set ismpotsByPotcndleadsource) {
//        this.ismpotsByPotcndleadsource = ismpotsByPotcndleadsource;
//    }
//
//    public Set getIsmpotsByPotcndcanrefreson() {
//        return this.ismpotsByPotcndcanrefreson;
//    }
//
//    public void setIsmpotsByPotcndcanrefreson(Set ismpotsByPotcndcanrefreson) {
//        this.ismpotsByPotcndcanrefreson = ismpotsByPotcndcanrefreson;
//    }
//
//    public Set getIsmpotsByPotcndcancreason() {
//        return this.ismpotsByPotcndcancreason;
//    }
//
//    public void setIsmpotsByPotcndcancreason(Set ismpotsByPotcndcancreason) {
//        this.ismpotsByPotcndcancreason = ismpotsByPotcndcancreason;
//    }
//
//    public Set getIsmpotsByPotcndrtotype() {
//        return this.ismpotsByPotcndrtotype;
//    }
//
//    public void setIsmpotsByPotcndrtotype(Set ismpotsByPotcndrtotype) {
//        this.ismpotsByPotcndrtotype = ismpotsByPotcndrtotype;
//    }
//
//    public Set getIsmpotsByPotcndbillstate() {
//        return this.ismpotsByPotcndbillstate;
//    }
//
//    public void setIsmpotsByPotcndbillstate(Set ismpotsByPotcndbillstate) {
//        this.ismpotsByPotcndbillstate = ismpotsByPotcndbillstate;
//    }
//
//    public Set getIsmpotsByPotcndcardtype() {
//        return this.ismpotsByPotcndcardtype;
//    }
//
//    public void setIsmpotsByPotcndcardtype(Set ismpotsByPotcndcardtype) {
//        this.ismpotsByPotcndcardtype = ismpotsByPotcndcardtype;
//    }
//
//    public Set getIsmpotsByPotcndcanrefinstracc() {
//        return this.ismpotsByPotcndcanrefinstracc;
//    }
//
//    public void setIsmpotsByPotcndcanrefinstracc(Set ismpotsByPotcndcanrefinstracc) {
//        this.ismpotsByPotcndcanrefinstracc = ismpotsByPotcndcanrefinstracc;
//    }
//
//    public Set getIsmpotsByPotcndinitiatedby() {
//        return this.ismpotsByPotcndinitiatedby;
//    }
//
//    public void setIsmpotsByPotcndinitiatedby(Set ismpotsByPotcndinitiatedby) {
//        this.ismpotsByPotcndinitiatedby = ismpotsByPotcndinitiatedby;
//    }

//    public Set getIsmpotsByPotbillcityrfnum() {
//        return this.ismpotsBypotbillcityrfnum;
//    }
//
//    public void setIsmpotsByPotbillcityrfnum(Set ismpotsBypotbillcityrfnum) {
//        this.ismpotsBypotbillcityrfnum = ismpotsBypotbillcityrfnum;
//    }
//
//    public Set getIsmsdtsBySdtcndcountry() {
//        return this.ismsdtsBySdtcndcountry;
//    }
//
//    public void setIsmsdtsBySdtcndcountry(Set ismsdtsBySdtcndcountry) {
//        this.ismsdtsBySdtcndcountry = ismsdtsBySdtcndcountry;
//    }
//
//    public Set getIsmsdtsBySdtcndstate() {
//        return this.ismsdtsBySdtcndstate;
//    }
//
//    public void setIsmsdtsBySdtcndstate(Set ismsdtsBySdtcndstate) {
//        this.ismsdtsBySdtcndstate = ismsdtsBySdtcndstate;
//    }
//
//    public Set getIsmsdtsBySdtcndcity() {
//        return this.ismsdtsBySdtcndcity;
//    }
//
//    public void setIsmsdtsBySdtcndcity(Set ismsdtsBySdtcndcity) {
//        this.ismsdtsBySdtcndcity = ismsdtsBySdtcndcity;
//    }

    public Set getIsmbpms() {
        return this.ismbpms;
    }

    public void setIsmbpms(Set ismbpms) {
        this.ismbpms = ismbpms;
    }

//    public Set getCrmcptsByCptcnddispositiontype() {
//        return this.crmcptsByCptcnddispositiontype;
//    }
//
//    public void setCrmcptsByCptcnddispositiontype(Set crmcptsByCptcnddispositiontype) {
//        this.crmcptsByCptcnddispositiontype = crmcptsByCptcnddispositiontype;
//    }
//
//    public Set getCrmcptsByCptcndcasetype() {
//        return this.crmcptsByCptcndcasetype;
//    }
//
//    public void setCrmcptsByCptcndcasetype(Set crmcptsByCptcndcasetype) {
//        this.crmcptsByCptcndcasetype = crmcptsByCptcndcasetype;
//    }
//
//    public Set getCrmpcmsByPcmcndstate() {
//        return this.crmpcmsByPcmcndstate;
//    }
//
//    public void setCrmpcmsByPcmcndstate(Set crmpcmsByPcmcndstate) {
//        this.crmpcmsByPcmcndstate = crmpcmsByPcmcndstate;
//    }
//
//    public Set getCrmpcmsByPcmcndcity() {
//        return this.crmpcmsByPcmcndcity;
//    }
//
//    public void setCrmpcmsByPcmcndcity(Set crmpcmsByPcmcndcity) {
//        this.crmpcmsByPcmcndcity = crmpcmsByPcmcndcity;
//    }

    public Set getIsmafmsByAfmcndbusinessid() {
        return this.ismafmsByAfmcndbusinessid;
    }

    public void setIsmafmsByAfmcndbusinessid(Set ismafmsByAfmcndbusinessid) {
        this.ismafmsByAfmcndbusinessid = ismafmsByAfmcndbusinessid;
    }

    public Set getIsmafmsByAfmcndchannelid() {
        return this.ismafmsByAfmcndchannelid;
    }

    public void setIsmafmsByAfmcndchannelid(Set ismafmsByAfmcndchannelid) {
        this.ismafmsByAfmcndchannelid = ismafmsByAfmcndchannelid;
    }

    public Set getIsmscts() {
        return this.ismscts;
    }

    public void setIsmscts(Set ismscts) {
        this.ismscts = ismscts;
    }

//    public Set getIsmpbisByPbicndpreprocess() {
//        return this.ismpbisByPbicndpreprocess;
//    }
//
//    public void setIsmpbisByPbicndpreprocess(Set ismpbisByPbicndpreprocess) {
//        this.ismpbisByPbicndpreprocess = ismpbisByPbicndpreprocess;
//    }
//
//    public Set getIsmpbisByPbicndchannelid() {
//        return this.ismpbisByPbicndchannelid;
//    }
//
//    public void setIsmpbisByPbicndchannelid(Set ismpbisByPbicndchannelid) {
//        this.ismpbisByPbicndchannelid = ismpbisByPbicndchannelid;
//    }
//
//    public Set getIsmpbisByPbicndsdshipper() {
//        return this.ismpbisByPbicndsdshipper;
//    }
//
//    public void setIsmpbisByPbicndsdshipper(Set ismpbisByPbicndsdshipper) {
//        this.ismpbisByPbicndsdshipper = ismpbisByPbicndsdshipper;
//    }
//
//    public Set getIsmpbisByPbicndprodtype() {
//        return this.ismpbisByPbicndprodtype;
//    }
//
//    public void setIsmpbisByPbicndprodtype(Set ismpbisByPbicndprodtype) {
//        this.ismpbisByPbicndprodtype = ismpbisByPbicndprodtype;
//    }
//
//    public Set getIsmpbisByPbicndwtunit() {
//        return this.ismpbisByPbicndwtunit;
//    }
//
//    public void setIsmpbisByPbicndwtunit(Set ismpbisByPbicndwtunit) {
//        this.ismpbisByPbicndwtunit = ismpbisByPbicndwtunit;
//    }
//
//    public Set getIsmpbisByPbicndhlwunit() {
//        return this.ismpbisByPbicndhlwunit;
//    }
//
//    public void setIsmpbisByPbicndhlwunit(Set ismpbisByPbicndhlwunit) {
//        this.ismpbisByPbicndhlwunit = ismpbisByPbicndhlwunit;
//    }
//
//    public Set getIsmpbisByPbicndpftype() {
//        return this.ismpbisByPbicndpftype;
//    }
//
//    public void setIsmpbisByPbicndpftype(Set ismpbisByPbicndpftype) {
//        this.ismpbisByPbicndpftype = ismpbisByPbicndpftype;
//    }
//
//    public Set getIsmpbisByPbicndpfpostpro() {
//        return this.ismpbisByPbicndpfpostpro;
//    }
//
//    public void setIsmpbisByPbicndpfpostpro(Set ismpbisByPbicndpfpostpro) {
//        this.ismpbisByPbicndpfpostpro = ismpbisByPbicndpfpostpro;
//    }
//
//    public Set getIsmpbisByPbicndpfexpunit() {
//        return this.ismpbisByPbicndpfexpunit;
//    }
//
//    public void setIsmpbisByPbicndpfexpunit(Set ismpbisByPbicndpfexpunit) {
//        this.ismpbisByPbicndpfexpunit = ismpbisByPbicndpfexpunit;
//    }

    public Set getIsmcczsByCczcndzip() {
        return this.ismcczsByCczcndzip;
    }

    public void setIsmcczsByCczcndzip(Set ismcczsByCczcndzip) {
        this.ismcczsByCczcndzip = ismcczsByCczcndzip;
    }

    public Set getIsmcczsByCczcndcntry() {
        return this.ismcczsByCczcndcntry;
    }

    public void setIsmcczsByCczcndcntry(Set ismcczsByCczcndcntry) {
        this.ismcczsByCczcndcntry = ismcczsByCczcndcntry;
    }

    public Set getIsmcczsByCczcndcity() {
        return this.ismcczsByCczcndcity;
    }

    public void setIsmcczsByCczcndcity(Set ismcczsByCczcndcity) {
        this.ismcczsByCczcndcity = ismcczsByCczcndcity;
    }

//    public Set getIsmrlmsByRlmcndstaterfnum() {
//        return this.ismrlmsByRlmcndstaterfnum;
//    }
//
//    public void setIsmrlmsByRlmcndstaterfnum(Set ismrlmsByRlmcndstaterfnum) {
//        this.ismrlmsByRlmcndstaterfnum = ismrlmsByRlmcndstaterfnum;
//    }
//
//    public Set getIsmrlmsByRlmcndcityrfnum() {
//        return this.ismrlmsByRlmcndcityrfnum;
//    }
//
//    public void setIsmrlmsByRlmcndcityrfnum(Set ismrlmsByRlmcndcityrfnum) {
//        this.ismrlmsByRlmcndcityrfnum = ismrlmsByRlmcndcityrfnum;
//    }

    public Set getIsmhlms() {
        return this.ismhlms;
    }

    public void setIsmhlms(Set ismhlms) {
        this.ismhlms = ismhlms;
    }

    public Set getIsmapms() {
        return this.ismapms;
    }

    public void setIsmapms(Set ismapms) {
        this.ismapms = ismapms;
    }

    public Set getIsmzvmsByZvmcity() {
        return this.ismzvmsByZvmcity;
    }

    public void setIsmzvmsByZvmcity(Set ismzvmsByZvmcity) {
        this.ismzvmsByZvmcity = ismzvmsByZvmcity;
    }

    public Set getIsmzvmsByZvmcndzip() {
        return this.ismzvmsByZvmcndzip;
    }

    public void setIsmzvmsByZvmcndzip(Set ismzvmsByZvmcndzip) {
        this.ismzvmsByZvmcndzip = ismzvmsByZvmcndzip;
    }

//    public Set getIsmstlsByStlcndreqrepinstrven() {
//        return this.ismstlsByStlcndreqrepinstrven;
//    }
//
//    public void setIsmstlsByStlcndreqrepinstrven(Set ismstlsByStlcndreqrepinstrven) {
//        this.ismstlsByStlcndreqrepinstrven = ismstlsByStlcndreqrepinstrven;
//    }
//
//    public Set getIsmstlsByStlreason11cnd() {
//        return this.ismstlsByStlreason11cnd;
//    }
//
//    public void setIsmstlsByStlreason11cnd(Set ismstlsByStlreason11cnd) {
//        this.ismstlsByStlreason11cnd = ismstlsByStlreason11cnd;
//    }
//
//    public Set getIsmstlsByStlcndtobeverreason() {
//        return this.ismstlsByStlcndtobeverreason;
//    }
//
//    public void setIsmstlsByStlcndtobeverreason(Set ismstlsByStlcndtobeverreason) {
//        this.ismstlsByStlcndtobeverreason = ismstlsByStlcndtobeverreason;
//    }
//
//    public Set getIsmstlsByStlcndpayproc() {
//        return this.ismstlsByStlcndpayproc;
//    }
//
//    public void setIsmstlsByStlcndpayproc(Set ismstlsByStlcndpayproc) {
//        this.ismstlsByStlcndpayproc = ismstlsByStlcndpayproc;
//    }
//
//    public Set getIsmstlsByStlcndcanrefinstracc() {
//        return this.ismstlsByStlcndcanrefinstracc;
//    }
//
//    public void setIsmstlsByStlcndcanrefinstracc(Set ismstlsByStlcndcanrefinstracc) {
//        this.ismstlsByStlcndcanrefinstracc = ismstlsByStlcndcanrefinstracc;
//    }
//
//    public Set getIsmstlsByStlcndinitiatedby() {
//        return this.ismstlsByStlcndinitiatedby;
//    }
//
//    public void setIsmstlsByStlcndinitiatedby(Set ismstlsByStlcndinitiatedby) {
//        this.ismstlsByStlcndinitiatedby = ismstlsByStlcndinitiatedby;
//    }
//
//    public Set getIsmstlsByStlcndcanrefreason() {
//        return this.ismstlsByStlcndcanrefreason;
//    }
//
//    public void setIsmstlsByStlcndcanrefreason(Set ismstlsByStlcndcanrefreason) {
//        this.ismstlsByStlcndcanrefreason = ismstlsByStlcndcanrefreason;
//    }
//
//    public Set getIsmstlsByStlcndrefreason() {
//        return this.ismstlsByStlcndrefreason;
//    }
//
//    public void setIsmstlsByStlcndrefreason(Set ismstlsByStlcndrefreason) {
//        this.ismstlsByStlcndrefreason = ismstlsByStlcndrefreason;
//    }
//
//    public Set getIsmstlsByStlcndchqnotclrrea() {
//        return this.ismstlsByStlcndchqnotclrrea;
//    }
//
//    public void setIsmstlsByStlcndchqnotclrrea(Set ismstlsByStlcndchqnotclrrea) {
//        this.ismstlsByStlcndchqnotclrrea = ismstlsByStlcndchqnotclrrea;
//    }
//
//    public Set getIsmstlsByStlcndcancreason() {
//        return this.ismstlsByStlcndcancreason;
//    }
//
//    public void setIsmstlsByStlcndcancreason(Set ismstlsByStlcndcancreason) {
//        this.ismstlsByStlcndcancreason = ismstlsByStlcndcancreason;
//    }

//    public Set getIsmstlsByStlcndpaynotproc() {
//        return this.ismstlsByStlcndpaynotproc;
//    }
//
//    public void setIsmstlsByStlcndpaynotproc(Set ismstlsByStlcndpaynotproc) {
//        this.ismstlsByStlcndpaynotproc = ismstlsByStlcndpaynotproc;
//    }
//
//    public Set getIsmstlsByStlcndemioptions() {
//        return this.ismstlsByStlcndemioptions;
//    }
//
//    public void setIsmstlsByStlcndemioptions(Set ismstlsByStlcndemioptions) {
//        this.ismstlsByStlcndemioptions = ismstlsByStlcndemioptions;
//    }
//
//    public Set getIsmstlsByStlchknbnkdrescnd() {
//        return this.ismstlsByStlchknbnkdrescnd;
//    }
//
//    public void setIsmstlsByStlchknbnkdrescnd(Set ismstlsByStlchknbnkdrescnd) {
//        this.ismstlsByStlchknbnkdrescnd = ismstlsByStlchknbnkdrescnd;
//    }
//
//    public Set getIsmstlsByStlcndcanrefreson() {
//        return this.ismstlsByStlcndcanrefreson;
//    }
//
//    public void setIsmstlsByStlcndcanrefreson(Set ismstlsByStlcndcanrefreson) {
//        this.ismstlsByStlcndcanrefreson = ismstlsByStlcndcanrefreson;
//    }
//
//    public Set getIsmstlsByStlcndaltcntry() {
//        return this.ismstlsByStlcndaltcntry;
//    }
//
//    public void setIsmstlsByStlcndaltcntry(Set ismstlsByStlcndaltcntry) {
//        this.ismstlsByStlcndaltcntry = ismstlsByStlcndaltcntry;
//    }
//
//    public Set getIsmstlsByStlcndalttitle() {
//        return this.ismstlsByStlcndalttitle;
//    }
//
//    public void setIsmstlsByStlcndalttitle(Set ismstlsByStlcndalttitle) {
//        this.ismstlsByStlcndalttitle = ismstlsByStlcndalttitle;
//    }
//
//    public Set getIsmstlsByStlcndchqreqinstracc() {
//        return this.ismstlsByStlcndchqreqinstracc;
//    }
//
//    public void setIsmstlsByStlcndchqreqinstracc(Set ismstlsByStlcndchqreqinstracc) {
//        this.ismstlsByStlcndchqreqinstracc = ismstlsByStlcndchqreqinstracc;
//    }
//
//    public Set getIsmstlsByStlcndreqrepreason() {
//        return this.ismstlsByStlcndreqrepreason;
//    }
//
//    public void setIsmstlsByStlcndreqrepreason(Set ismstlsByStlcndreqrepreason) {
//        this.ismstlsByStlcndreqrepreason = ismstlsByStlcndreqrepreason;
//    }
//
//    public Set getIsmstlsByStlcndtobeverinstrcrm() {
//        return this.ismstlsByStlcndtobeverinstrcrm;
//    }
//
//    public void setIsmstlsByStlcndtobeverinstrcrm(Set ismstlsByStlcndtobeverinstrcrm) {
//        this.ismstlsByStlcndtobeverinstrcrm = ismstlsByStlcndtobeverinstrcrm;
//    }
//
//    public Set getIsmstlsByStlcndaltcity() {
//        return this.ismstlsByStlcndaltcity;
//    }
//
//    public void setIsmstlsByStlcndaltcity(Set ismstlsByStlcndaltcity) {
//        this.ismstlsByStlcndaltcity = ismstlsByStlcndaltcity;
//    }
//
//    public Set getIsmstlsByStlcndacccanref() {
//        return this.ismstlsByStlcndacccanref;
//    }
//
//    public void setIsmstlsByStlcndacccanref(Set ismstlsByStlcndacccanref) {
//        this.ismstlsByStlcndacccanref = ismstlsByStlcndacccanref;
//    }
//
//    public Set getIsmstlsByStlreason12cnd() {
//        return this.ismstlsByStlreason12cnd;
//    }
//
//    public void setIsmstlsByStlreason12cnd(Set ismstlsByStlreason12cnd) {
//        this.ismstlsByStlreason12cnd = ismstlsByStlreason12cnd;
//    }
//
//    public Set getIsmstlsByStlcndsalretreason() {
//        return this.ismstlsByStlcndsalretreason;
//    }
//
//    public void setIsmstlsByStlcndsalretreason(Set ismstlsByStlcndsalretreason) {
//        this.ismstlsByStlcndsalretreason = ismstlsByStlcndsalretreason;
//    }
//
//    public Set getIsmstlsByStlchkundclrrescnd() {
//        return this.ismstlsByStlchkundclrrescnd;
//    }
//
//    public void setIsmstlsByStlchkundclrrescnd(Set ismstlsByStlchkundclrrescnd) {
//        this.ismstlsByStlchkundclrrescnd = ismstlsByStlchkundclrrescnd;
//    }
//
//    public Set getIsmstlsByStlretreson() {
//        return this.ismstlsByStlretreson;
//    }
//
//    public void setIsmstlsByStlretreson(Set ismstlsByStlretreson) {
//        this.ismstlsByStlretreson = ismstlsByStlretreson;
//    }
//
//    public Set getIsmstlsByStlcndaltstate() {
//        return this.ismstlsByStlcndaltstate;
//    }
//
//    public void setIsmstlsByStlcndaltstate(Set ismstlsByStlcndaltstate) {
//        this.ismstlsByStlcndaltstate = ismstlsByStlcndaltstate;
//    }
//
//    public Set getIsmstlsByStlcndsalretinstracc() {
//        return this.ismstlsByStlcndsalretinstracc;
//    }
//
//    public void setIsmstlsByStlcndsalretinstracc(Set ismstlsByStlcndsalretinstracc) {
//        this.ismstlsByStlcndsalretinstracc = ismstlsByStlcndsalretinstracc;
//    }
//
//    public Set getIsmstlsByStlcndrefundby() {
//        return this.ismstlsByStlcndrefundby;
//    }
//
//    public void setIsmstlsByStlcndrefundby(Set ismstlsByStlcndrefundby) {
//        this.ismstlsByStlcndrefundby = ismstlsByStlcndrefundby;
//    }
//
//    public Set getIsmstlsByStlcndrtotype() {
//        return this.ismstlsByStlcndrtotype;
//    }
//
//    public void setIsmstlsByStlcndrtotype(Set ismstlsByStlcndrtotype) {
//        this.ismstlsByStlcndrtotype = ismstlsByStlcndrtotype;
//    }
//
//    public Set getIsmstlsByStlcndsalretinstrven() {
//        return this.ismstlsByStlcndsalretinstrven;
//    }
//
//    public void setIsmstlsByStlcndsalretinstrven(Set ismstlsByStlcndsalretinstrven) {
//        this.ismstlsByStlcndsalretinstrven = ismstlsByStlcndsalretinstrven;
//    }
//
//    public Set getIsmstlsByStlcndrefinstracc() {
//        return this.ismstlsByStlcndrefinstracc;
//    }
//
//    public void setIsmstlsByStlcndrefinstracc(Set ismstlsByStlcndrefinstracc) {
//        this.ismstlsByStlcndrefinstracc = ismstlsByStlcndrefinstracc;
//    }
//
//    public Set getIsmpstsByPstcndtobeverinstrcrm() {
//        return this.ismpstsByPstcndtobeverinstrcrm;
//    }
//
//    public void setIsmpstsByPstcndtobeverinstrcrm(Set ismpstsByPstcndtobeverinstrcrm) {
//        this.ismpstsByPstcndtobeverinstrcrm = ismpstsByPstcndtobeverinstrcrm;
//    }
//
//    public Set getIsmpstsByPstcndsalretinstracc() {
//        return this.ismpstsByPstcndsalretinstracc;
//    }
//
//    public void setIsmpstsByPstcndsalretinstracc(Set ismpstsByPstcndsalretinstracc) {
//        this.ismpstsByPstcndsalretinstracc = ismpstsByPstcndsalretinstracc;
//    }
//
//    public Set getIsmpstsByPstcndreqrepinstrven() {
//        return this.ismpstsByPstcndreqrepinstrven;
//    }
//
//    public void setIsmpstsByPstcndreqrepinstrven(Set ismpstsByPstcndreqrepinstrven) {
//        this.ismpstsByPstcndreqrepinstrven = ismpstsByPstcndreqrepinstrven;
//    }
//
//    public Set getIsmpstsByPstcndcanrefreson() {
//        return this.ismpstsByPstcndcanrefreson;
//    }
//
//    public void setIsmpstsByPstcndcanrefreson(Set ismpstsByPstcndcanrefreson) {
//        this.ismpstsByPstcndcanrefreson = ismpstsByPstcndcanrefreson;
//    }
//
//    public Set getIsmpstsByPstcndrefinstracc() {
//        return this.ismpstsByPstcndrefinstracc;
//    }
//
//    public void setIsmpstsByPstcndrefinstracc(Set ismpstsByPstcndrefinstracc) {
//        this.ismpstsByPstcndrefinstracc = ismpstsByPstcndrefinstracc;
//    }
//
//    public Set getIsmpstsByPstcndinitiatedby() {
//        return this.ismpstsByPstcndinitiatedby;
//    }
//
//    public void setIsmpstsByPstcndinitiatedby(Set ismpstsByPstcndinitiatedby) {
//        this.ismpstsByPstcndinitiatedby = ismpstsByPstcndinitiatedby;
//    }
//
//    public Set getIsmpstsByPstcndrefreason() {
//        return this.ismpstsByPstcndrefreason;
//    }
//
//    public void setIsmpstsByPstcndrefreason(Set ismpstsByPstcndrefreason) {
//        this.ismpstsByPstcndrefreason = ismpstsByPstcndrefreason;
//    }
//
//    public Set getIsmpstsByPstcndrtotype() {
//        return this.ismpstsByPstcndrtotype;
//    }
//
//    public void setIsmpstsByPstcndrtotype(Set ismpstsByPstcndrtotype) {
//        this.ismpstsByPstcndrtotype = ismpstsByPstcndrtotype;
//    }
//
//    public Set getIsmpstsByPstcndrecvcity() {
//        return this.ismpstsByPstcndrecvcity;
//    }
//
//    public void setIsmpstsByPstcndrecvcity(Set ismpstsByPstcndrecvcity) {
//        this.ismpstsByPstcndrecvcity = ismpstsByPstcndrecvcity;
//    }
//
//    public Set getIsmpstsByPstcndpaynotproc() {
//        return this.ismpstsByPstcndpaynotproc;
//    }
//
//    public void setIsmpstsByPstcndpaynotproc(Set ismpstsByPstcndpaynotproc) {
//        this.ismpstsByPstcndpaynotproc = ismpstsByPstcndpaynotproc;
//    }
//
//    public Set getIsmpstsByPstcndretreason() {
//        return this.ismpstsByPstcndretreason;
//    }
//
//    public void setIsmpstsByPstcndretreason(Set ismpstsByPstcndretreason) {
//        this.ismpstsByPstcndretreason = ismpstsByPstcndretreason;
//    }
//
//    public Set getIsmpstsByPstcndemioptions() {
//        return this.ismpstsByPstcndemioptions;
//    }
//
//    public void setIsmpstsByPstcndemioptions(Set ismpstsByPstcndemioptions) {
//        this.ismpstsByPstcndemioptions = ismpstsByPstcndemioptions;
//    }
//
//    public Set getIsmpstsByPstreason11cnd() {
//        return this.ismpstsByPstreason11cnd;
//    }
//
//    public void setIsmpstsByPstreason11cnd(Set ismpstsByPstreason11cnd) {
//        this.ismpstsByPstreason11cnd = ismpstsByPstreason11cnd;
//    }
//
//    public Set getIsmpstsByPstcndsalretreason() {
//        return this.ismpstsByPstcndsalretreason;
//    }
//
//    public void setIsmpstsByPstcndsalretreason(Set ismpstsByPstcndsalretreason) {
//        this.ismpstsByPstcndsalretreason = ismpstsByPstcndsalretreason;
//    }
//
//    public Set getIsmpstsByPstsalereturn() {
//        return this.ismpstsByPstsalereturn;
//    }
//
//    public void setIsmpstsByPstsalereturn(Set ismpstsByPstsalereturn) {
//        this.ismpstsByPstsalereturn = ismpstsByPstsalereturn;
//    }
//
//    public Set getIsmpstsByPstcndpftype() {
//        return this.ismpstsByPstcndpftype;
//    }
//
//    public void setIsmpstsByPstcndpftype(Set ismpstsByPstcndpftype) {
//        this.ismpstsByPstcndpftype = ismpstsByPstcndpftype;
//    }
//
//    public Set getIsmpstsByPstreason12cnd() {
//        return this.ismpstsByPstreason12cnd;
//    }
//
//    public void setIsmpstsByPstreason12cnd(Set ismpstsByPstreason12cnd) {
//        this.ismpstsByPstreason12cnd = ismpstsByPstreason12cnd;
//    }
//
//    public Set getIsmpstsByPstcndmercountry() {
//        return this.ismpstsByPstcndmercountry;
//    }
//
//    public void setIsmpstsByPstcndmercountry(Set ismpstsByPstcndmercountry) {
//        this.ismpstsByPstcndmercountry = ismpstsByPstcndmercountry;
//    }
//
//    public Set getIsmpstsByPstcndpayproc() {
//        return this.ismpstsByPstcndpayproc;
//    }
//
//    public void setIsmpstsByPstcndpayproc(Set ismpstsByPstcndpayproc) {
//        this.ismpstsByPstcndpayproc = ismpstsByPstcndpayproc;
//    }
//
//    public Set getIsmpstsByPstcndrecvcountry() {
//        return this.ismpstsByPstcndrecvcountry;
//    }
//
//    public void setIsmpstsByPstcndrecvcountry(Set ismpstsByPstcndrecvcountry) {
//        this.ismpstsByPstcndrecvcountry = ismpstsByPstcndrecvcountry;
//    }
//
//    public Set getIsmpstsByPstchknbnkdrescnd() {
//        return this.ismpstsByPstchknbnkdrescnd;
//    }
//
//    public void setIsmpstsByPstchknbnkdrescnd(Set ismpstsByPstchknbnkdrescnd) {
//        this.ismpstsByPstchknbnkdrescnd = ismpstsByPstchknbnkdrescnd;
//    }
//
//    public Set getIsmpstsByPstcndalttitle() {
//        return this.ismpstsByPstcndalttitle;
//    }
//
//    public void setIsmpstsByPstcndalttitle(Set ismpstsByPstcndalttitle) {
//        this.ismpstsByPstcndalttitle = ismpstsByPstcndalttitle;
//    }
//
//    public Set getIsmpstsByPstcndmerstate() {
//        return this.ismpstsByPstcndmerstate;
//    }
//
//    public void setIsmpstsByPstcndmerstate(Set ismpstsByPstcndmerstate) {
//        this.ismpstsByPstcndmerstate = ismpstsByPstcndmerstate;
//    }
//
//    public Set getIsmpstsByPstcndpostprocess() {
//        return this.ismpstsByPstcndpostprocess;
//    }
//
//    public void setIsmpstsByPstcndpostprocess(Set ismpstsByPstcndpostprocess) {
//        this.ismpstsByPstcndpostprocess = ismpstsByPstcndpostprocess;
//    }
//
//    public Set getIsmpstsByPstcndrecvstate() {
//        return this.ismpstsByPstcndrecvstate;
//    }
//
//    public void setIsmpstsByPstcndrecvstate(Set ismpstsByPstcndrecvstate) {
//        this.ismpstsByPstcndrecvstate = ismpstsByPstcndrecvstate;
//    }
//
//    public Set getIsmpstsByPstcndchqnotclrrea() {
//        return this.ismpstsByPstcndchqnotclrrea;
//    }
//
//    public void setIsmpstsByPstcndchqnotclrrea(Set ismpstsByPstcndchqnotclrrea) {
//        this.ismpstsByPstcndchqnotclrrea = ismpstsByPstcndchqnotclrrea;
//    }
//
//    public Set getIsmpstsByPstcndpreprocess() {
//        return this.ismpstsByPstcndpreprocess;
//    }
//
//    public void setIsmpstsByPstcndpreprocess(Set ismpstsByPstcndpreprocess) {
//        this.ismpstsByPstcndpreprocess = ismpstsByPstcndpreprocess;
//    }
//
//    public Set getIsmpstsByPstcndtobeverreason() {
//        return this.ismpstsByPstcndtobeverreason;
//    }
//
//    public void setIsmpstsByPstcndtobeverreason(Set ismpstsByPstcndtobeverreason) {
//        this.ismpstsByPstcndtobeverreason = ismpstsByPstcndtobeverreason;
//    }
//
//    public Set getIsmpstsByPstcndchannelid() {
//        return this.ismpstsByPstcndchannelid;
//    }
//
//    public void setIsmpstsByPstcndchannelid(Set ismpstsByPstcndchannelid) {
//        this.ismpstsByPstcndchannelid = ismpstsByPstcndchannelid;
//    }

//    public Set getIsmpstsByPstcndaltstate() {
//        return this.ismpstsByPstcndaltstate;
//    }
//
//    public void setIsmpstsByPstcndaltstate(Set ismpstsByPstcndaltstate) {
//        this.ismpstsByPstcndaltstate = ismpstsByPstcndaltstate;
//    }
//
//    public Set getIsmpstsByPstcndcanrefinstracc() {
//        return this.ismpstsByPstcndcanrefinstracc;
//    }

//    public void setIsmpstsByPstcndcanrefinstracc(Set ismpstsByPstcndcanrefinstracc) {
//        this.ismpstsByPstcndcanrefinstracc = ismpstsByPstcndcanrefinstracc;
//    }
//
//    public Set getIsmpstsByPstcndaltcity() {
//        return this.ismpstsByPstcndaltcity;
//    }
//
//    public void setIsmpstsByPstcndaltcity(Set ismpstsByPstcndaltcity) {
//        this.ismpstsByPstcndaltcity = ismpstsByPstcndaltcity;
//    }
//
//    public Set getIsmpstsByPstchkundclrrescnd() {
//        return this.ismpstsByPstchkundclrrescnd;
//    }
//
//    public void setIsmpstsByPstchkundclrrescnd(Set ismpstsByPstchkundclrrescnd) {
//        this.ismpstsByPstchkundclrrescnd = ismpstsByPstchkundclrrescnd;
//    }
//
//    public Set getIsmpstsByPstcndacccanref() {
//        return this.ismpstsByPstcndacccanref;
//    }
//
//    public void setIsmpstsByPstcndacccanref(Set ismpstsByPstcndacccanref) {
//        this.ismpstsByPstcndacccanref = ismpstsByPstcndacccanref;
//    }
//
//    public Set getIsmpstsByPstcndreqrepreason() {
//        return this.ismpstsByPstcndreqrepreason;
//    }
//
//    public void setIsmpstsByPstcndreqrepreason(Set ismpstsByPstcndreqrepreason) {
//        this.ismpstsByPstcndreqrepreason = ismpstsByPstcndreqrepreason;
//    }
//
//    public Set getIsmpstsByPstcndaltcntry() {
//        return this.ismpstsByPstcndaltcntry;
//    }
//
//    public void setIsmpstsByPstcndaltcntry(Set ismpstsByPstcndaltcntry) {
//        this.ismpstsByPstcndaltcntry = ismpstsByPstcndaltcntry;
//    }
//
//    public Set getIsmpstsByPstcndrefundby() {
//        return this.ismpstsByPstcndrefundby;
//    }
//
//    public void setIsmpstsByPstcndrefundby(Set ismpstsByPstcndrefundby) {
//        this.ismpstsByPstcndrefundby = ismpstsByPstcndrefundby;
//    }
//
//    public Set getIsmpstsByPstcndcanrefreason() {
//        return this.ismpstsByPstcndcanrefreason;
//    }
//
//    public void setIsmpstsByPstcndcanrefreason(Set ismpstsByPstcndcanrefreason) {
//        this.ismpstsByPstcndcanrefreason = ismpstsByPstcndcanrefreason;
//    }
//
//    public Set getIsmpstsByPstcndchqreqinstracc() {
//        return this.ismpstsByPstcndchqreqinstracc;
//    }
//
//    public void setIsmpstsByPstcndchqreqinstracc(Set ismpstsByPstcndchqreqinstracc) {
//        this.ismpstsByPstcndchqreqinstracc = ismpstsByPstcndchqreqinstracc;
//    }
//
//    public Set getIsmpstsByPstcndsalretinstrven() {
//        return this.ismpstsByPstcndsalretinstrven;
//    }
//
//    public void setIsmpstsByPstcndsalretinstrven(Set ismpstsByPstcndsalretinstrven) {
//        this.ismpstsByPstcndsalretinstrven = ismpstsByPstcndsalretinstrven;
//    }
//
//    public Set getIsmpstsByPstcndcancreason() {
//        return this.ismpstsByPstcndcancreason;
//    }
//
//    public void setIsmpstsByPstcndcancreason(Set ismpstsByPstcndcancreason) {
//        this.ismpstsByPstcndcancreason = ismpstsByPstcndcancreason;
//    }
//
//    public Set getIsmpstsByPstcndmercity() {
//        return this.ismpstsByPstcndmercity;
//    }
//
//    public void setIsmpstsByPstcndmercity(Set ismpstsByPstcndmercity) {
//        this.ismpstsByPstcndmercity = ismpstsByPstcndmercity;
//    }
//
//    public Set getIsmbsisByBsicndmaristat() {
//        return this.ismbsisByBsicndmaristat;
//    }
//
//    public void setIsmbsisByBsicndmaristat(Set ismbsisByBsicndmaristat) {
//        this.ismbsisByBsicndmaristat = ismbsisByBsicndmaristat;
//    }
//
//    public Set getIsmbsisByBsicndhouseincm() {
//        return this.ismbsisByBsicndhouseincm;
//    }
//
//    public void setIsmbsisByBsicndhouseincm(Set ismbsisByBsicndhouseincm) {
//        this.ismbsisByBsicndhouseincm = ismbsisByBsicndhouseincm;
//    }
//
//    public Set getIsmbsisByBsicndeducation() {
//        return this.ismbsisByBsicndeducation;
//    }
//
//    public void setIsmbsisByBsicndeducation(Set ismbsisByBsicndeducation) {
//        this.ismbsisByBsicndeducation = ismbsisByBsicndeducation;
//    }
//
//    public Set getIsmbsisByBsicndoccupation() {
//        return this.ismbsisByBsicndoccupation;
//    }
//
//    public void setIsmbsisByBsicndoccupation(Set ismbsisByBsicndoccupation) {
//        this.ismbsisByBsicndoccupation = ismbsisByBsicndoccupation;
//    }

    public Set getIsmidcs() {
        return this.ismidcs;
    }

    public void setIsmidcs(Set ismidcs) {
        this.ismidcs = ismidcs;
    }

    public Set getIsmdats() {
        return this.ismdats;
    }

    public void setIsmdats(Set ismdats) {
        this.ismdats = ismdats;
    }

    public Set getOctueasByUeacndoccur() {
        return this.octueasByUeacndoccur;
    }

    public void setOctueasByUeacndoccur(Set octueasByUeacndoccur) {
        this.octueasByUeacndoccur = octueasByUeacndoccur;
    }

    public Set getOctueasByUeacndevent() {
        return this.octueasByUeacndevent;
    }

    public void setOctueasByUeacndevent(Set octueasByUeacndevent) {
        this.octueasByUeacndevent = octueasByUeacndevent;
    }

    public Set getIsmaprsByAprcndtype() {
        return this.ismaprsByAprcndtype;
    }

    public void setIsmaprsByAprcndtype(Set ismaprsByAprcndtype) {
        this.ismaprsByAprcndtype = ismaprsByAprcndtype;
    }

    public Set getIsmaprsByAprcndelement() {
        return this.ismaprsByAprcndelement;
    }

    public void setIsmaprsByAprcndelement(Set ismaprsByAprcndelement) {
        this.ismaprsByAprcndelement = ismaprsByAprcndelement;
    }


//    public Set getIsmpilsByPilcndpricetype() {
//        return this.ismpilsByPilcndpricetype;
//    }
//
//    public void setIsmpilsByPilcndpricetype(Set ismpilsByPilcndpricetype) {
//        this.ismpilsByPilcndpricetype = ismpilsByPilcndpricetype;
//    }
//
//    public Set getIsmpilsByPilcndinvnttype() {
//        return this.ismpilsByPilcndinvnttype;
//    }
//
//    public void setIsmpilsByPilcndinvnttype(Set ismpilsByPilcndinvnttype) {
//        this.ismpilsByPilcndinvnttype = ismpilsByPilcndinvnttype;
//    }
//
//    public Set getCrmcttsByCttcndtodispositiontype() {
//        return this.crmcttsByCttcndtodispositiontype;
//    }
//
//    public void setCrmcttsByCttcndtodispositiontype(Set crmcttsByCttcndtodispositiontype) {
//        this.crmcttsByCttcndtodispositiontype = crmcttsByCttcndtodispositiontype;
//    }
//
//    public Set getCrmcttsByCttcndfeedbacktype() {
//        return this.crmcttsByCttcndfeedbacktype;
//    }
//
//    public void setCrmcttsByCttcndfeedbacktype(Set crmcttsByCttcndfeedbacktype) {
//        this.crmcttsByCttcndfeedbacktype = crmcttsByCttcndfeedbacktype;
//    }
//
//    public Set getCrmcttsByCttcndcaseassignto() {
//        return this.crmcttsByCttcndcaseassignto;
//    }
//
//    public void setCrmcttsByCttcndcaseassignto(Set crmcttsByCttcndcaseassignto) {
//        this.crmcttsByCttcndcaseassignto = crmcttsByCttcndcaseassignto;
//    }
//
//    public Set getCrmcttsByCttcnddispositiontype() {
//        return this.crmcttsByCttcnddispositiontype;
//    }
//
//    public void setCrmcttsByCttcnddispositiontype(Set crmcttsByCttcnddispositiontype) {
//        this.crmcttsByCttcnddispositiontype = crmcttsByCttcnddispositiontype;
//    }
//
//    public Set getCrmcttsByCttcndcasetype() {
//        return this.crmcttsByCttcndcasetype;
//    }
//
//    public void setCrmcttsByCttcndcasetype(Set crmcttsByCttcndcasetype) {
//        this.crmcttsByCttcndcasetype = crmcttsByCttcndcasetype;
//    }
//
//    public Set getIsmsclsBySclcndhlwunit() {
//        return this.ismsclsBySclcndhlwunit;
//    }
//
//    public void setIsmsclsBySclcndhlwunit(Set ismsclsBySclcndhlwunit) {
//        this.ismsclsBySclcndhlwunit = ismsclsBySclcndhlwunit;
//    }
//
//    public Set getIsmsclsBySclcndwunit() {
//        return this.ismsclsBySclcndwunit;
//    }
//
//    public void setIsmsclsBySclcndwunit(Set ismsclsBySclcndwunit) {
//        this.ismsclsBySclcndwunit = ismsclsBySclcndwunit;
//    }

    public Set getIsmsmls() {
        return this.ismsmls;
    }

    public void setIsmsmls(Set ismsmls) {
        this.ismsmls = ismsmls;
    }

    public Set getIsmpmlsByPmlcndpdurunit() {
        return this.ismpmlsByPmlcndpdurunit;
    }

    public void setIsmpmlsByPmlcndpdurunit(Set ismpmlsByPmlcndpdurunit) {
        this.ismpmlsByPmlcndpdurunit = ismpmlsByPmlcndpdurunit;
    }

    public Set getIsmpmlsByPmlcndpricety() {
        return this.ismpmlsByPmlcndpricety;
    }

    public void setIsmpmlsByPmlcndpricety(Set ismpmlsByPmlcndpricety) {
        this.ismpmlsByPmlcndpricety = ismpmlsByPmlcndpricety;
    }

    public Set getIsmscms() {
        return this.ismscms;
    }

    public void setIsmscms(Set ismscms) {
        this.ismscms = ismscms;
    }

    public Set getIsmoses() {
        return this.ismoses;
    }

    public void setIsmoses(Set ismoses) {
        this.ismoses = ismoses;
    }

    public Set getIsmmtms() {
        return this.ismmtms;
    }

    public void setIsmmtms(Set ismmtms) {
        this.ismmtms = ismmtms;
    }

//    public Set getCrmchtsByChtcndcaseassignto() {
//        return this.crmchtsByChtcndcaseassignto;
//    }
//
//    public void setCrmchtsByChtcndcaseassignto(Set crmchtsByChtcndcaseassignto) {
//        this.crmchtsByChtcndcaseassignto = crmchtsByChtcndcaseassignto;
//    }
//
//    public Set getCrmchtsByChtcndcity() {
//        return this.crmchtsByChtcndcity;
//    }
//
//    public void setCrmchtsByChtcndcity(Set crmchtsByChtcndcity) {
//        this.crmchtsByChtcndcity = crmchtsByChtcndcity;
//    }
//
//    public Set getCrmchtsByChtcndfeedbacktype() {
//        return this.crmchtsByChtcndfeedbacktype;
//    }
//
//    public void setCrmchtsByChtcndfeedbacktype(Set crmchtsByChtcndfeedbacktype) {
//        this.crmchtsByChtcndfeedbacktype = crmchtsByChtcndfeedbacktype;
//    }
//
//    public Set getCrmchtsByChtcndcasetype() {
//        return this.crmchtsByChtcndcasetype;
//    }
//
//    public void setCrmchtsByChtcndcasetype(Set crmchtsByChtcndcasetype) {
//        this.crmchtsByChtcndcasetype = crmchtsByChtcndcasetype;
//    }
//
//    public Set getCrmchtsByChtcnddisptype() {
//        return this.crmchtsByChtcnddisptype;
//    }
//
//    public void setCrmchtsByChtcnddisptype(Set crmchtsByChtcnddisptype) {
//        this.crmchtsByChtcnddisptype = crmchtsByChtcnddisptype;
//    }
//
//    public Set getCrmchtsByChtcndstate() {
//        return this.crmchtsByChtcndstate;
//    }
//
//    public void setCrmchtsByChtcndstate(Set crmchtsByChtcndstate) {
//        this.crmchtsByChtcndstate = crmchtsByChtcndstate;
//    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cndrfnum", getCndrfnum())
            .toString();
    }
    
	/**
	 * @return the ismccasByCndagenttype
	 */
//	public Set getIsmccasByCndagenttype() {
//		return ismccasByCndagenttype;
//	}
//
//	/**
//	 * @param ismccasByCndagenttype the ismccasByCndagenttype to set
//	 */
//	public void setIsmccasByCndagenttype(Set ismccasByCndagenttype) {
//		this.ismccasByCndagenttype = ismccasByCndagenttype;
//	}
//
//	public Set getIsmssisBySsicndSla() {
//		return ismssisBySsicndSla;
//	}
//
//	public void setIsmssisBySsicndSla(Set ismssisBySsicndSla) {
//		this.ismssisBySsicndSla = ismssisBySsicndSla;
//	}

	public String getCndvalue() {
		return cndvalue;
	}

	public void setCndvalue(String cndvalue) {
		this.cndvalue = cndvalue;
	}
	
	
	

}
