/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function mensaje(){
    jQuery('#message').show([{
            summary:'infooo text',
            detail:'detailll',
            severity:'info'},
            {
                summary:'warn text',
                detail:'detail',
                severity:'warn'
    }])
}  