package wordSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class USWordCheck {

    public static void main(String[] args) 
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            Thread.sleep(3000); 
            
            handleCookiePopup(driver);


           
            List<String> urls = List.of(
            		"http://ttbs-migration-stg.allsocialassets.com/articles/5-key-trends-in-media-and-entertainment-industry-to-watch-closely-in-2023/",
            		"http://ttbs-migration-stg.allsocialassets.com/careers/",
            		"http://ttbs-migration-stg.allsocialassets.com/case-studies/a-financial-technology-solutions-provider-future-proofs-its-contact-cent",
            		"http://ttbs-migration-stg.allsocialassets.com/contact-us-leadership-assurance/",
            		"http://ttbs-migration-stg.allsocialassets.com/customer-services/",
            		"http://ttbs-migration-stg.allsocialassets.com/podcasts/shaping-the-future-of-learning-how-ai-is-transforming-k-12-education-ft-supr",
            		"http://ttbs-migration-stg.allsocialassets.com/regulatory-guidelines/",
            		"http://ttbs-migration-stg.allsocialassets.com/regulatory-guidelines/#tab-dnd",
            		"http://ttbs-migration-stg.allsocialassets.com/security-audit/",
            		"http://ttbs-migration-stg.allsocialassets.com/solutionfinder/",
            		"http://ttbs-migration-stg.allsocialassets.com/",
            		"http://ttbs-migration-stg.allsocialassets.com/#existing-customer",
            		"http://ttbs-migration-stg.allsocialassets.com/#FAQ",
            		"http://ttbs-migration-stg.allsocialassets.com/#GetInTouch",
            		"http://ttbs-migration-stg.allsocialassets.com/#new-customer",
            		"http://ttbs-migration-stg.allsocialassets.com/#Overview",
            		"http://ttbs-migration-stg.allsocialassets.com/#RelatedContent",
            		"http://ttbs-migration-stg.allsocialassets.com/#Services",
            		"http://ttbs-migration-stg.allsocialassets.com/#SuccessStories",
            		"http://ttbs-migration-stg.allsocialassets.com/aboutus/",
            		"http://ttbs-migration-stg.allsocialassets.com/about-us/",
            		"http://ttbs-migration-stg.allsocialassets.com/about-us/#awardRecognition",
            		"http://ttbs-migration-stg.allsocialassets.com/aboutus-ttml/",
            		"http://ttbs-migration-stg.allsocialassets.com/aboutus-ttns/",
            		"http://ttbs-migration-stg.allsocialassets.com/affirmative-action/",
            		"http://ttbs-migration-stg.allsocialassets.com/announcements/",
            		"http://ttbs-migration-stg.allsocialassets.com/annual-report/",
            		"http://ttbs-migration-stg.allsocialassets.com/annual-return/",
            		"http://ttbs-migration-stg.allsocialassets.com/annual-secretarial-compliance-reports/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/addressing-cybersecurity-issues/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/an-overview-of-virtual-firewalls/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/building-an-organized-and-valuable-business-continuity-plan/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/digital-insurance-reshaping-the-industry-through-technology/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/digital-transformation-initiatives-for-the-retail-and-wholesale-sectors/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/eliminating-risks-from-bfsi-operations-with-endpoint-security-solutions/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/future-of-indian-edtech-landscape/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/how-enterprises-can-benefit-from-unified-communications/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/how-indias-sme-retailers-benefit-from-going-digital/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/indias-on-demand-home-service-market-is-ripe-for-disruption/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/latency-or-bandwidth-which-do-i-need/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/managed-ill-to-build-connectivity-for-remote-workforce/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/production-linked-incentive-scheme-set-to-boost-domestic-manufacturing/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/remote-and-secure-data-connectivity-for-businesses-managed-ill/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/security-risks-for-the-it-industry-and-how-to-manage-them-effectively/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/sip-trunk-integrated-communications-for-a-more-effective-tomorrow/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/top-5-trends-in-the-education-industry-for-2023/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/using-digital-tools-to-operate-in-a-circular-economy/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/voice-solutions-an-integral-part-of-business-communications/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/where-is-indias-manufacturing-industry-headed-in-2023/",
            		"http://ttbs-migration-stg.allsocialassets.com/articles/wireless-epabx-and-ivr-customer-satisfaction-and-brand-growth-roadmap/",
            		"http://ttbs-migration-stg.allsocialassets.com/auto-dialer/",
            		"http://ttbs-migration-stg.allsocialassets.com/automated-calling-system/",
            		"http://ttbs-migration-stg.allsocialassets.com/board-of-directors/",
            		"http://ttbs-migration-stg.allsocialassets.com/board-of-directors-ttml/",
            		"http://ttbs-migration-stg.allsocialassets.com/board-of-directors-ttns/",
            		"http://ttbs-migration-stg.allsocialassets.com/brochures/",
            		"http://ttbs-migration-stg.allsocialassets.com/brochures/cloud-and-saas/microsoft-365/",
            		"http://ttbs-migration-stg.allsocialassets.com/brochures/cloud-and-saas/smartflo/",
            		"http://ttbs-migration-stg.allsocialassets.com/brochures/collaboration/zoom/",
            		"http://ttbs-migration-stg.allsocialassets.com/brochures/data-services/ez-cloud-connect/",
            		"http://ttbs-migration-stg.allsocialassets.com/brochures/data-services/sd-wan/",
            		"http://ttbs-migration-stg.allsocialassets.com/brochures/data-services/smart-internet/",
            		"http://ttbs-migration-stg.allsocialassets.com/business-communication/integrated-solutions/smartflo-cpaas/",
            		"http://ttbs-migration-stg.allsocialassets.com/business-phone-systems/",
            		"http://ttbs-migration-stg.allsocialassets.com/call-answering-service/",
            		"http://ttbs-migration-stg.allsocialassets.com/call-center/",
            		"http://ttbs-migration-stg.allsocialassets.com/call-management-software/",
            		"http://ttbs-migration-stg.allsocialassets.com/call-masking/",
            		"http://ttbs-migration-stg.allsocialassets.com/call-tracking-software/",
            		"http://ttbs-migration-stg.allsocialassets.com/campaign/channel-partner/registration/",
            		"http://ttbs-migration-stg.allsocialassets.com/case-studies/",
            		"http://ttbs-migration-stg.allsocialassets.com/case-studies/adopts-smartflo-to-eliminate-capex-and-facilitate-remote-working/",
            		"http://ttbs-migration-stg.allsocialassets.com/case-studies/scalability-and-ease-of-management-transform-it/",
            		"http://ttbs-migration-stg.allsocialassets.com/case-studies/secure-connectivity-for-a-investment-management/",
            		"http://ttbs-migration-stg.allsocialassets.com/case-studies/ttbs-smartflo-makes-bpo-services-more-agile-and-productive/",
            		"http://ttbs-migration-stg.allsocialassets.com/case-studies/ttbs-webcasting-helps-social-pension-scheme-administrators-train/",
            		"http://ttbs-migration-stg.allsocialassets.com/case-studies/voice-and-data-connectivity-for-a-leading-online-s/",
            		"http://ttbs-migration-stg.allsocialassets.com/channel-partners/",
            		"http://ttbs-migration-stg.allsocialassets.com/click2call/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-and-saas/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-and-saas/google-workspace-solutions/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-and-saas/microsoft-365/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-and-saas/microsoft-365/copilot-ms-365-business/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-and-saas/microsoft-azure/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-and-saas/microsoft-azure/azure-virtual-desktop/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-and-saas/smart-cloud-services/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-and-saas/smartflo/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-and-saas/smartflo/email-platform/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-and-saas/smartflo/ucaas/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-and-saas/smartflo/whatsapp-business-platform/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-and-saas/smart-internet-telephony/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-phone-system/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-solutions/smart-hosted-pbx/",
            		"http://ttbs-migration-stg.allsocialassets.com/cloud-telephony/",
            		"http://ttbs-migration-stg.allsocialassets.com/collaboration/",
            		"http://ttbs-migration-stg.allsocialassets.com/collaboration/international-bridging-service/",
            		"http://ttbs-migration-stg.allsocialassets.com/collaboration/zoom/",
            		"http://ttbs-migration-stg.allsocialassets.com/collection-recovery-policy/",
            		"http://ttbs-migration-stg.allsocialassets.com/conclave/",
            		"http://ttbs-migration-stg.allsocialassets.com/corporate-governance/",
            		"http://ttbs-migration-stg.allsocialassets.com/corporate-sustainability/",
            		"http://ttbs-migration-stg.allsocialassets.com/credit-rating/",
            		"http://ttbs-migration-stg.allsocialassets.com/cyber-security/",
            		"http://ttbs-migration-stg.allsocialassets.com/cyber-security/data-loss-prevention-solution/",
            		"http://ttbs-migration-stg.allsocialassets.com/cyber-security/ddos-prevention/",
            		"http://ttbs-migration-stg.allsocialassets.com/cyber-security/email-security/",
            		"http://ttbs-migration-stg.allsocialassets.com/cyber-security/endpoint-security/",
            		"http://ttbs-migration-stg.allsocialassets.com/cyber-security/multifactor-authentication/",
            		"http://ttbs-migration-stg.allsocialassets.com/cyber-security/virtual-firewall/",
            		"http://ttbs-migration-stg.allsocialassets.com/cyber-security/web-security/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/business-broadband/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/ez-cloud-connect/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/ill-burstable-bandwidth/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/leased-line-service-provider/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/retail-broadband/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/sd-wan/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/sd-wan/sd-wan-edge/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/smart-internet/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/smart-mpls-vpn/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/smartoffice/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/tatatelewifi/",
            		"http://ttbs-migration-stg.allsocialassets.com/data-services/ultralola/",
            		"http://ttbs-migration-stg.allsocialassets.com/details-of-authorised-persons/",
            		"http://ttbs-migration-stg.allsocialassets.com/dobig-cxoround/",
            		"http://ttbs-migration-stg.allsocialassets.com/dobig-cxoround/disruption-in-manufacturing-and-its-emerging-growth-opportunities/",
            		"http://ttbs-migration-stg.allsocialassets.com/dropbox/",
            		"http://ttbs-migration-stg.allsocialassets.com/experience-zone/",
            		"http://ttbs-migration-stg.allsocialassets.com/experience-zone/banking/",
            		"http://ttbs-migration-stg.allsocialassets.com/experience-zone/bfsi/",
            		"http://ttbs-migration-stg.allsocialassets.com/experience-zone/diagnostics/",
            		"http://ttbs-migration-stg.allsocialassets.com/experience-zone/education/",
            		"http://ttbs-migration-stg.allsocialassets.com/experience-zone/healthcare/",
            		"http://ttbs-migration-stg.allsocialassets.com/experience-zone/insurance/",
            		"http://ttbs-migration-stg.allsocialassets.com/experience-zone/it-ites/",
            		"http://ttbs-migration-stg.allsocialassets.com/experience-zone/manufacturing/",
            		"http://ttbs-migration-stg.allsocialassets.com/experience-zone/retail/",
            		"http://ttbs-migration-stg.allsocialassets.com/familiarisation-programme/",
            		"http://ttbs-migration-stg.allsocialassets.com/faqs/",
            		"http://ttbs-migration-stg.allsocialassets.com/fccbs-conversion/",
            		"http://ttbs-migration-stg.allsocialassets.com/financial-results/",
            		"http://ttbs-migration-stg.allsocialassets.com/general-meetings-postal-ballot/",
            		"http://ttbs-migration-stg.allsocialassets.com/go-green/",
            		"http://ttbs-migration-stg.allsocialassets.com/guidelines/childonlinesafetywebcontent/",
            		"http://ttbs-migration-stg.allsocialassets.com/iepf/",
            		"http://ttbs-migration-stg.allsocialassets.com/imanage/",
            		"http://ttbs-migration-stg.allsocialassets.com/industry/bfsi/",
            		"http://ttbs-migration-stg.allsocialassets.com/industry/education/",
            		"http://ttbs-migration-stg.allsocialassets.com/industry/healthcare/",
            		"http://ttbs-migration-stg.allsocialassets.com/industry/it-ites/",
            		"http://ttbs-migration-stg.allsocialassets.com/industry/manufacturing/",
            		"http://ttbs-migration-stg.allsocialassets.com/industry/retail/",
            		"http://ttbs-migration-stg.allsocialassets.com/industry/services/",
            		"http://ttbs-migration-stg.allsocialassets.com/industry/telecom-media-entertainment/",
            		"http://ttbs-migration-stg.allsocialassets.com/infographics/",
            		"http://ttbs-migration-stg.allsocialassets.com/infographics/accelerating-the-growth-of-indias-sme-edtech-landscape/",
            		"http://ttbs-migration-stg.allsocialassets.com/infographics/disruptive-technology-trends-that-will-transform-businesses/",
            		"http://ttbs-migration-stg.allsocialassets.com/infographics/making-indian-sme-retailers-future-ready/",
            		"http://ttbs-migration-stg.allsocialassets.com/infographics/revolutionise-your-virtual-experiences-with-zoom-solutions/",
            		"http://ttbs-migration-stg.allsocialassets.com/infographics/security-concerns-and-solutions-for-e-commerce-businesses/",
            		"http://ttbs-migration-stg.allsocialassets.com/infographics/smartoffice-an-all-in-one-starter-box-for-your-business/",
            		"http://ttbs-migration-stg.allsocialassets.com/infographics/smartvpn-a-high-performing-and-secured-data-networking-services/",
            		"http://ttbs-migration-stg.allsocialassets.com/internet-leased-line-providers-in-bangalore/",
            		"http://ttbs-migration-stg.allsocialassets.com/internet-leased-line-providers-in-chennai/",
            		"http://ttbs-migration-stg.allsocialassets.com/internet-leased-line-providers-in-delhi/",
            		"http://ttbs-migration-stg.allsocialassets.com/internet-leased-line-providers-in-mumbai/",
            		"http://ttbs-migration-stg.allsocialassets.com/internet-leased-line-providers-in-pune/",
            		"http://ttbs-migration-stg.allsocialassets.com/investor-relations-ttml/",
            		"http://ttbs-migration-stg.allsocialassets.com/investors-share-holding-patterns/",
            		"http://ttbs-migration-stg.allsocialassets.com/investor-updates/",
            		"http://ttbs-migration-stg.allsocialassets.com/knowledgehub/",
            		"http://ttbs-migration-stg.allsocialassets.com/know-your-service-manager/",
            		"http://ttbs-migration-stg.allsocialassets.com/marketing-solutions/",
            		"http://ttbs-migration-stg.allsocialassets.com/marketing-solutions/call-register-services/",
            		"http://ttbs-migration-stg.allsocialassets.com/marketing-solutions/hosted-ivr-service/",
            		"http://ttbs-migration-stg.allsocialassets.com/marketing-solutions/hosted-obd-service/",
            		"http://ttbs-migration-stg.allsocialassets.com/marketing-solutions/smart-single-number-solution/",
            		"http://ttbs-migration-stg.allsocialassets.com/marketing-solutions/sms-solutions/",
            		"http://ttbs-migration-stg.allsocialassets.com/marketing-solutions/toll-free-services/",
            		"http://ttbs-migration-stg.allsocialassets.com/marketing-solutions/truecaller-business-id/",
            		"http://ttbs-migration-stg.allsocialassets.com/media/",
            		"http://ttbs-migration-stg.allsocialassets.com/microsoft-365-business/",
            		"http://ttbs-migration-stg.allsocialassets.com/microsoft-365-partner/",
            		"http://ttbs-migration-stg.allsocialassets.com/microsoft-365-plans/",
            		"http://ttbs-migration-stg.allsocialassets.com/microsoft-365-provider/",
            		"http://ttbs-migration-stg.allsocialassets.com/microsoft-365-services/",
            		"http://ttbs-migration-stg.allsocialassets.com/microsoft-365-solutions/",
            		"http://ttbs-migration-stg.allsocialassets.com/microsoft-office-365-enterprise/",
            		"http://ttbs-migration-stg.allsocialassets.com/microsoft-office-pricing/",
            		"http://ttbs-migration-stg.allsocialassets.com/missed-call-service-provider/",
            		"http://ttbs-migration-stg.allsocialassets.com/mpls-vpn-provider/",
            		"http://ttbs-migration-stg.allsocialassets.com/mpls-vpn-service/",
            		"http://ttbs-migration-stg.allsocialassets.com/mpls-vpn-solution/",
            		"http://ttbs-migration-stg.allsocialassets.com/need/cost-optimization/",
            		"http://ttbs-migration-stg.allsocialassets.com/need/drive-digital-transformation/",
            		"http://ttbs-migration-stg.allsocialassets.com/need/enhance-customer-experience/",
            		"http://ttbs-migration-stg.allsocialassets.com/need/ensure-business-continuity/",
            		"http://ttbs-migration-stg.allsocialassets.com/need/grow-your-business/",
            		"http://ttbs-migration-stg.allsocialassets.com/need/improve-productivity/",
            		"http://ttbs-migration-stg.allsocialassets.com/need/secure-your-business/",
            		"http://ttbs-migration-stg.allsocialassets.com/network-connectivity/internet-leased-line/sd-wan-ready-ill/",
            		"http://ttbs-migration-stg.allsocialassets.com/newspaper-publications/",
            		"http://ttbs-migration-stg.allsocialassets.com/nomination-form/",
            		"http://ttbs-migration-stg.allsocialassets.com/organization/large/",
            		"http://ttbs-migration-stg.allsocialassets.com/organization/medium/",
            		"http://ttbs-migration-stg.allsocialassets.com/organization/small/",
            		"http://ttbs-migration-stg.allsocialassets.com/our-csr/",
            		"http://ttbs-migration-stg.allsocialassets.com/picture-gallery/",
            		"http://ttbs-migration-stg.allsocialassets.com/podcasts/",
            		"http://ttbs-migration-stg.allsocialassets.com/podcasts/connecting-farmers-and-technology-through-agritech-ft-sachin-farfad-patil/",
            		"http://ttbs-migration-stg.allsocialassets.com/podcasts/decoding-the-sme-digital-insights-report-ft-prabhu-ram/",
            		"http://ttbs-migration-stg.allsocialassets.com/podcasts/navigating-business-communication-challenges-ft-abhimanyu-khanna/",
            		"http://ttbs-migration-stg.allsocialassets.com/podcasts/navigating-the-digital-shift-in-education-ft-swami-ar-co-founder-camu/",
            		"http://ttbs-migration-stg.allsocialassets.com/podcasts/redefining-healthcare-through-the-power-of-ai-ft-raghuvamshi-thakur/",
            		"http://ttbs-migration-stg.allsocialassets.com/policies/",
            		"http://ttbs-migration-stg.allsocialassets.com/policies-ttml/",
            		"http://ttbs-migration-stg.allsocialassets.com/presentations/",
            		"http://ttbs-migration-stg.allsocialassets.com/privacy-policy/",
            		"http://ttbs-migration-stg.allsocialassets.com/quality-of-service/",
            		"http://ttbs-migration-stg.allsocialassets.com/registration/",
            		"http://ttbs-migration-stg.allsocialassets.com/scheme-of-arrangement-bharti-airtel-limit/",
            		"http://ttbs-migration-stg.allsocialassets.com/sd-wan-business/",
            		"http://ttbs-migration-stg.allsocialassets.com/sd-wan-companies/",
            		"http://ttbs-migration-stg.allsocialassets.com/sd-wan-provider/",
            		"http://ttbs-migration-stg.allsocialassets.com/sd-wan-services/",
            		"http://ttbs-migration-stg.allsocialassets.com/sd-wan-solutions/",
            		"http://ttbs-migration-stg.allsocialassets.com/stories/",
            		"http://ttbs-migration-stg.allsocialassets.com/symposium/",
            		"http://ttbs-migration-stg.allsocialassets.com/tata-code-conduct/",
            		"http://ttbs-migration-stg.allsocialassets.com/terms-and-conditions/",
            		"http://ttbs-migration-stg.allsocialassets.com/ttml-annualreport/",
            		"http://ttbs-migration-stg.allsocialassets.com/ttml-annual-return/",
            		"http://ttbs-migration-stg.allsocialassets.com/virtual-number/",
            		"http://ttbs-migration-stg.allsocialassets.com/voice-services/",
            		"http://ttbs-migration-stg.allsocialassets.com/voice-services/centrex-service-provider/",
            		"http://ttbs-migration-stg.allsocialassets.com/voice-services/pri-lines-service/",
            		"http://ttbs-migration-stg.allsocialassets.com/voice-services/sip-trunk-services/",
            		"http://ttbs-migration-stg.allsocialassets.com/voip-number/",
            		"http://ttbs-migration-stg.allsocialassets.com/webinars/",
            		"http://ttbs-migration-stg.allsocialassets.com/webinars/rise-of-software-as-a-service-empowering-workplaces-drive-business-value/",
            		"http://ttbs-migration-stg.allsocialassets.com/whatsappconsent/",
            		"http://ttbs-migration-stg.allsocialassets.com/whatsapp-for-business/",
            		"http://ttbs-migration-stg.allsocialassets.com/whatsapp-for-business-communication/",
            		"http://ttbs-migration-stg.allsocialassets.com/whatsapp-for-business-solution/",
            		"http://ttbs-migration-stg.allsocialassets.com/whistle-blower-policy/",
            		"http://ttbs-migration-stg.allsocialassets.com/whitepapers/",
            		"http://ttbs-migration-stg.allsocialassets.com/whitepapers/adding-revenue-as-a-global-it-outsourcing-partner/",
            		"http://ttbs-migration-stg.allsocialassets.com/whitepapers/digital-workspace-connect-collaborate-and-excel/",
            		"http://ttbs-migration-stg.allsocialassets.com/whitepapers/how-can-indian-manufacturing-industry-take-advantage-of-post-pandemic/",
            		"http://ttbs-migration-stg.allsocialassets.com/whitepapers/leveraging-the-digital-momentum-to-transform-indias-education-sector/",
            		"http://ttbs-migration-stg.allsocialassets.com/whitepapers/media-&-entertainment-industry-gets-a-digital-spin/",
            		"http://ttbs-migration-stg.allsocialassets.com/whitepapers/scale-adapt-thrive-small-and-medium-enterprises-and-the-cloud-imperative/",
            		"http://ttbs-migration-stg.allsocialassets.com/whitepapers/why-digital-means-transformation-setting-up-manufacturing-smes-for-growth"
            		 );


            
            List<String> forWord = List.of("Overview", "In Focus");

            
            for (String url : urls) 
            {
                try {
                    driver.get(url);
                    Thread.sleep(2000); 

                    WebElement body = driver.findElement(By.tagName("body"));
                    String pageText = body.getText();

                    boolean foundInFocus = false;
                    boolean foundOverview = false;

                    for (String word : forWord) 
                    {
                        
                        String regex = "(\\b\\w+\\b\\s+){0,3}\\b" + Pattern.quote(word) + "\\b(\\s+\\b\\w+\\b){0,3}";
                        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                        Matcher matcher = pattern.matcher(pageText);

                        if (word.equals("Overview") && matcher.find()) 
                        
                        {
                        	foundOverview = true;
                        }
                        if (word.equals("In Focus") && matcher.find()) 
                        {
                        	  foundInFocus = true;
                            
                        }
                    }
                    if (foundInFocus && foundOverview) 
                    {
                        System.out.println(url);
                    }
                } 
                catch (Exception e) 
                {
                    System.err.println("Error processing URL: " + url);
                    e.printStackTrace();
                }
            }
        } 
        catch (Exception e) 
        {
            System.err.println("Error during authentication or URL processing.");
            e.printStackTrace();
        } 
        finally 
        {
            driver.quit();
        }
    }

    private static void handleCookiePopup(WebDriver driver) 
    {
        
    }
}