class DependentSelectBoxTagLib {
    
    def selectDependency = {attrs ->
        def target = attrs["target"]
        def dependent = attrs["dependent"]
        def controller = attrs["controller"]
        def action = attrs["action"]
        out << """<script>
            var oldonload = window.onload;
            function updateSelect(e){
                var template = \$('${dependent}');
                var data = e.evalJSON();
                data.each(function(item){
                    template.options[template.options.length] = new Option(item.title + " (" + item.space + ")", item.id, true, false);
                });
            }
            var func = function(){
                 var template = \$('${dependent}');
                 \$('${target}').onchange =  function(){
                 var selectedSpace = \$F('${target}');
                 var urlString = '${createLink(controller: controller, action: action)}' + "/" + selectedSpace;
                 var request = new Ajax.Request(urlString, 
                      {asynchronous: true,
                       evalScripts: true,
                       onSuccess: function(e){
                          updateSelect(e.responseText);
                        }
                       });
                 template.options.length = 0;
                }
            }
            if (typeof window.onload != 'function') {
                    window.onload = func;
            }
            else {
                    window.onload = function() {
                            oldonload();
                            func();
                    }
            }
            
        </script>"""
    
    }
}
