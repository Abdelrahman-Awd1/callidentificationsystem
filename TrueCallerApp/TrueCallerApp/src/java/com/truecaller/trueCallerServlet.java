/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truecaller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author gmka2
 */
@WebServlet(name = "trueCallerServlet", urlPatterns = {"/trueCallerServlet"})
public class trueCallerServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TrueCaller/TrueCallerService.wsdl")
    private TrueCallerService_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String number = request.getParameter("number");
            String callerID = trueCaller(number);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>TrueCaller</title>");            
            out.println("</head>");
            out.println("<body style=\"background-color: #0088ff;\"><center> <h1><svg fill=\"#FFFFFF\" width=\"50%\" hieght=\"50%\" viewBox=\"0 0 119 23\" xmlns=\"http://www.w3.org/2000/svg\" class=\"logo\"><g><path d=\"M48.8233692 11.8217184c.3240571 1.4620725-1.7621991 2.6943952-4.5580232 3.1154441.0076025-.6542941.2458146-2.3975954 1.8958766-3.2555819 1.1549484-.5834307 2.5078789-.5557845 2.6621466.1401378m3.2855526 5.2346706c-.3478149 0-2.405245 2.2657197-5.0353976 2.4592433-1.8515287.1474466-2.8433398-1.1859279-2.8433398-2.0537653 5.7053691-.8065072 8.038707-3.038543 8.038707-5.8756182 0-1.9066365-1.6380248-3.90669822-4.3302646-3.90669822-5.9074693 0-7.4792888 5.68972112-7.6665007 9.64916962-.137162 1.7372637-1.1343583 2.0010151-1.9145662 1.9546202-.7802078-.0467126-1.3526137-.7365972-1.2129175-1.9673311l1.1565322-7.82292962c.0142548-.13441787.3177217-1.71533732-.8109347-1.76395655-1.19011-.05116142-2.750209.50112763-3.0172472 2.19167868-.2613364 1.6568671-.3712561 2.6019233-.5819091 3.9470554-.1672552 1.128411-.3775914 2.2727107-.4723061 3.3544092-.2141374 1.0318081-.579058 1.5307113-1.6655838 1.5373845-1.378589-.1429977-1.3478622-1.3486275-1.2030977-2.3658181l.9598173-6.8832756c.0142547-.1347356.3177217-1.7312259-.8109347-1.7798452-1.1901101-.0511614-2.7502091.5166985-3.0172473 2.2072496-.0662052.41946008-.1225905.79284308-.1735907 1.13921538l-.0006336-.0108043c-.2819265 1.9705088-1.208166 2.8491505-2.2642817 2.6146342-1.0564325-.2341985-.5226728-3.1643811-.5176044-3.2015605.3636535-2.44939236-.5109523-3.31119207-2.6418733-2.4001376-1.1220041.4795191-2.2937414 1.71978615-3.0606449 2.6480004l.18151-1.2332761c.0142547-.13473564.3177217-1.7156551-.8109347-1.76395654-1.1901101-.0514792-2.750209.50080986-3.0169305 2.1913609-.00982.06260124-.0193231.12393135-.029143.18462595l-.0003168-.0044488s-.1292427.7235686-.3205726 1.3699183c-.0807767.2605737-.1625037.5173341-.2192058.6819404-.2328269.6819403-.4871944 1.3530764-.7726054 2.005146-.286678.6511164-.5999649 1.2847553-.946196 1.8856636-.1729572.2999774-.3538337.5920106-.5467474.8703795-.1913299.2793223-.3937468.5452981-.6063004.7925253-.4232066.4954077-.8926617.9158211-1.3627504 1.2046765-.0817271.0498903-.1631373.0943785-.2442308.1360067-2.2908905.9911333-2.70997903-1.2135741-2.7600289-1.5440578-.02407463-.1604752-.03389455-.3295303-.04181383-.5036698-.01678888-.2815466-.0177392-.5764398-.00918637-.8799127.00791928-.3028375.02850942-.613937.05923625-.9288498.06145364-.6301434.16567142-1.2755398.29586445-1.9231607.11467124-.5818419.25500096-1.166226.4127531-1.7487035 1.3497628.1499888 2.6016432.2694713 3.0517754.3018841 1.0801903.0775366 1.6947268-.4807901 1.7979943-1.0886894.0807767-.4760236.0243913-.2154499.2204728-1.33972993.2901626-1.66608254-.0500499-1.66608254-1.420086-1.66608254 0 0-.9705875.00031777-2.33777272.00031777.03357776-.0829387.066522-.1658774.10009975-.24818054.51095217-1.25075356 1.16856957-2.36073378 1.82808757-3.6083096.8476802-1.60316356.6272073-1.97559322-.4095854-2.86281475-3.2424717-2.3798002-4.8713101 1.8669149-5.25048542 2.5386865-.30505082.6673228-.56226918 1.3317856-.86320198 2.12939523-.2543674.6774915-.4878279 1.36038517-.69753055 2.0515409H.9357743c-1.02919018 0-.93352522.9377474-.93352522.9377474 0 .8792772 2.10399543 1.67180244 3.52883304 2.08840254-.11752217.5738976-.2201561 1.1538329-.30441728 1.7417125-.1105532.7903008-.18626157 1.5942659-.21413745 2.4201572-.0269256.8255737-.0063355 1.6740269.1194228 2.5606129.066522.4429752.1555347.8970725.2949141 1.3610207.0693729.2316563.14983282.4661726.2445475.7032311.096932.2364229.2087523.4747525.3395789.7127643.2607028.4747525.6072507.9520472 1.0580164 1.368965.4479147.4166001 1.0035317.7588413 1.5778382.959356.2866781.102005.5758903.1731861.8581336.2173565.2822433.0441704.62435634.0613302.88886044.0603768.5201386-.0022244 1.04154426-.0778543 1.5433101-.2227587.500182-.1471287.9705875-.3667097 1.3877754-.6326855.4168711-.2682002.7814749-.5786642 1.1004637-.9059701.6376608-.658743 1.0919109-1.3848537 1.4647508-2.1074689.0829941-.1630175.1615534-.3260349.2366282-.4896878-.1289259 1.5046539-.0646213 2.8348507.5004988 3.5314086 1.0757556 1.3267012 2.5892892.8958014 2.7356375-.1572976.1286092-.9205876.4156041-2.770025.6243564-4.1374012.2467649-1.4252108.5381946-2.2692152 1.051681-3.4335346.6034494-1.3699183 2.3178161-2.4992827 2.2867725-.9107367-.0912302 4.6645862 3.4128947 4.7592825 5.4364302 2.6851798-.2888955 2.0439143-.3794921 3.9708883.7067169 5.2832898 2.1220514 2.563155 5.3097217 1.2946061 6.9569328.1741394 1.4748875 2.0029217 5.3227093 1.584415 6.9917777-.4617238 1.2043647 1.6508295 3.4414041 1.8348199 5.1073047 1.7668165 4.7781794-.2402362 7.7371407-5.7844174 5.5840457-5.7844174\"></path><path d=\"M61.8309519 7.73821143c1.7739197 0 3.2567265.67081828 4.2165437 1.66258704l-1.9484607 2.65467363c-.6978473-.5834308-1.3374087-.8459111-2.0064298-.8459111-2.064399 0-3.3732983 1.6044346-3.3732983 4.1129327 0 2.5088159 1.3668684 4.1132506 3.2279002 4.1132506 1.0469294 0 1.8901748-.4960433 2.5880221-1.050239l1.7156337 2.712826c-1.3956946 1.225014-3.2275835 1.8084447-4.7978191 1.8084447-4.0131765 0-7.1245049-2.7709784-7.1245049-7.5842823 0-4.8129861 3.5183796-7.58428227 7.5024131-7.58428227\"></path> <g transform=\"translate(66.84 7.654)\"><path d=\"M5.90626552 11.9276956c.98864345 0 1.6285216-.4668081 2.3843381-1.2250139v-2.538051c-3.05304245.40833797-4.0416859 1.28348414-4.0416859 2.3921933 0 .9332986.6395614 1.3708716 1.6573478 1.3708716m2.3843381-6.33003322c-.08711213-1.28348415-.7269903-2.10016012-2.268083-2.10016012-1.22115363 0-2.44262403.4957255-3.83831868 1.31271924L.6722522 1.98045513C2.50414102.87206377 4.56854003.0843051 6.8369398.0843051c3.6929206 0 5.7281767 2.1004779 5.7281767 6.53436114v8.28433566H9.07587984l-.31993908-1.4874942h-.08711213c-1.2214704 1.0791562-2.58802208 1.8376798-4.2165437 1.8376798-2.61716504 0-4.27451284-1.9253851-4.27451284-4.3757308 0-3.0337765 2.413481-4.69636354 8.1128315-5.27979432\"></path></g> <path d=\"M81.4216455 22.556654h4.2745129V2.1082951h-4.2745129m6.4345768 20.4483589h4.2745129V2.1082951h-4.2745129m15.3511207 11.7265455c0-1.6625871-.697847-2.8294486-2.413481-2.8294486-1.3377255 0-2.50091.9040635-2.7917061 2.8294486h5.2051871zm-2.50091-6.09678806c4.100289 0 6.135861 3.00485916 6.135861 6.94269916 0 .7585235-.087428 1.4585769-.174541 1.8087625h-8.6364542c.3782251 2.1875476 1.8318889 3.1503991 3.7512062 3.1503991 1.075756 0 2.064716-.3209505 3.111329-.9628515l1.424837 2.5962034c-1.482806 1.0210039-3.402124 1.6336697-5.117758 1.6336697-4.1291146 0-7.298729-2.8005312-7.298729-7.5842823 0-4.6966813 3.3441554-7.58460006 6.804249-7.58460006zm7.897174.35018558h3.489553l.290796 2.53773318h.116255c1.046613-1.9543024 2.616849-2.88791876 4.099972-2.88791876.814102 0 1.308583.11694038 1.715634.2917154l-.697848 3.70491256c-.523306-.1458577-.9595-.233563-1.570235-.233563-1.075756 0-2.413481.7000534-3.169615 2.6546736v8.4009583h-4.274512V8.08823812z\"></path></g></svg></h1>\n" +
"        ");

            out.println("<h1 style=\"color: white;\">Caller Name is: " + callerID + "</h1> </center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String trueCaller(java.lang.String number) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.truecaller.TrueCallerService port = service.getTrueCallerServicePort();
        return port.trueCaller(number);
    }

}
