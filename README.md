# 自定义Dialog之信息提示
<div id="article_content" class="article_content">

<p><span style="font-family:verdana,Arial,Helvetica,sans-serif; font-size:14px">对话框对于应用也是必不可少的一个组件，在Android中也不例外，对话框对于一些提示重要信息，或者一些需要用户额外交互的一些内容很有帮助。</span></p>
<p><span style="font-size:18px">自定义Dialog步骤：&nbsp;</span><br style="color:rgb(85,85,85); font-family:&quot;microsoft yahei&quot;; font-size:14px">
<span style="font-size:18px">1、主要创建<a target="_blank" target="_blank" href="http://lib.csdn.net/base/17" class="replace_word" title="Java EE知识库" style="">Java</a>类,并继承<strong><span style="color:#3366ff">Dialog&nbsp;</span></strong><br style="">
2、创建布局文件来加载和一些样式文件</span></p>
<p><span style="font-size:14px">效果图：&nbsp;</span><br>
</p>
<p><span style="font-size:14px">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img src="http://img.blog.csdn.net/20161010153951886?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" align="middle" alt=""><br>
</span></p>
<p><span style="font-size:14px">代码：</span></p>
<p><span style="font-size:14px"><span style="color:#333333">DialogBox</span><span style="color:#ff0000">.java</span><br>
</span></p>
<p></p>
<p><span style="font-size:14px"><strong><span style="color:#7F0055">public</span><span style="color:#7F0055">class</span></strong> DialogBox&nbsp;<strong><span style="color:#7F0055">extends</span></strong> Dialog {</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> DialogBox(Context context) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">super</span></strong>(context);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> DialogBox(Context context,<strong><span style="color:#7F0055">int</span></strong> theme) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">super</span></strong>(context,theme);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span><span style="color:#7F0055">static</span>
<span style="color:#7F0055">class</span></strong> Builder {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span></strong> Context<span style="color:#0000C0">context</span>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span></strong> String<span style="color:#0000C0">title</span>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span></strong> String<span style="color:#0000C0">message</span>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span></strong> String<span style="color:#0000C0">positiveButtonText</span>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span></strong> String<span style="color:#0000C0">negativeButtonText</span>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span></strong> View<span style="color:#0000C0">contentView</span>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">private&nbsp;</span></strong>DialogInterface.OnClickListener<span style="color:#0000C0">positiveButtonClickListener</span>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">private&nbsp;</span></strong>DialogInterface.OnClickListener<span style="color:#0000C0">negativeButtonClickListener</span>;</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public&nbsp;</span></strong>Builder(Context context) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">context</span> =context;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> Builder &nbsp;setMessage(String message) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">message</span> =message;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span><span style="color:#7F0055">this</span></strong>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#3F5FBF">/**</span></span></p>
<p><span style="color:#3F5FBF"><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;*Set the Dialog message from resource</span></span></p>
<p><span style="color:#3F5FBF"><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span></span></p>
<p><span style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF"> title</span></span></p>
<p><span style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@return</span></strong></span></p>
<p><span style="color:#3F5FBF"><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;*/</span></span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> Builder &nbsp;setMessage(<strong><span style="color:#7F0055">int</span></strong> message) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">message</span> =(String)<span style="color:#0000C0">context</span>.getText(message);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span><span style="color:#7F0055">this</span></strong>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#3F5FBF">/**</span></span></p>
<p><span style="color:#3F5FBF"><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;*Set the Dialog title from resource</span></span></p>
<p><span style="color:#3F5FBF"><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span></span></p>
<p><span style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF"> title</span></span></p>
<p><span style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@return</span></strong></span></p>
<p><span style="color:#3F5FBF"><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;*/</span></span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> Builder &nbsp;setTitle(<strong><span style="color:#7F0055">int</span></strong> title) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">title</span> =(String)<span style="color:#0000C0">context</span>.getText(title);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span><span style="color:#7F0055">this</span></strong>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#3F5FBF">/**</span></span></p>
<p><span style="color:#3F5FBF"><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;*Set the Dialog title from String</span></span></p>
<p><span style="color:#3F5FBF"><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span></span></p>
<p><span style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF"> title</span></span></p>
<p><span style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@return</span></strong></span></p>
<p><span style="color:#3F5FBF"><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;*/</span></span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> Builder &nbsp;setTitle(String title) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">title</span> = title;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span><span style="color:#7F0055">this</span></strong>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> Builder &nbsp;setContentView(View v) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">contentView</span> = v;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span><span style="color:#7F0055">this</span></strong>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#3F5FBF">/**</span></span></p>
<p><span style="color:#3F5FBF"><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;*Set the positive button resource and it's listener</span></span></p>
<p><span style="color:#3F5FBF"><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span></span></p>
<p><span style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF">positiveButtonText</span></span></p>
<p><span style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@return</span></strong></span></p>
<p><span style="color:#3F5FBF"><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;*/</span></span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> Builder &nbsp;setPositiveButton(<strong><span style="color:#7F0055">int</span></strong> positiveButtonText,</span><span style="font-size:14px">DialogInterface.OnClickListener
 &nbsp;listener) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">positiveButtonText</span> =(String)<span style="color:#0000C0">context</span></span><span style="font-size:14px">.getText(positiveButtonText);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">positiveButtonClickListener</span> =listener;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span><span style="color:#7F0055">this</span></strong>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> Builder &nbsp;setPositiveButton(String positiveButtonText,</span><span style="font-size:14px">&nbsp;DialogInterface.OnClickListener &nbsp;listener) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">positiveButtonText</span> =positiveButtonText;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">positiveButtonClickListener</span> =listener;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span><span style="color:#7F0055">this</span></strong>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> Builder &nbsp;setNegativeButton(<strong><span style="color:#7F0055">int</span></strong> negativeButtonText,</span><span style="font-size:14px">DialogInterface.OnClickListener
 &nbsp;listener) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">negativeButtonText</span> =(String)<span style="color:#0000C0">context</span></span><span style="font-size:14px">.getText(negativeButtonText);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">negativeButtonClickListener</span> =listener;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span><span style="color:#7F0055">this</span></strong>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> Builder setNegativeButton(String negativeButtonText,</span><span style="font-size:14px">DialogInterface.OnClickListener &nbsp;listener) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">negativeButtonText</span> =negativeButtonText;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">negativeButtonClickListener</span> =listener;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span><span style="color:#7F0055">this</span></strong>;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> DialogBoxcreate() {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; LayoutInflater inflater =(LayoutInflater)<span style="color:#0000C0">context</span></span><span style="font-size:14px">.getSystemService(Context.</span><span style="font-size:14px"><em><span style="color:#0000C0">LAYOUT_INFLATER_SERVICE</span></em></span><span style="font-size:14px">);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">final</span></strong> DialogBoxdialog =<strong><span style="color:#7F0055">new</span></strong> DialogBox(<span style="color:#0000C0">context</span>, R.style.<em><span style="color:#0000C0">Dialog</span></em>);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; View layout =inflater.inflate(R.layout.<em><span style="color:#0000C0">dialog_normal_layout</span></em>,<strong><u><span style="color:#7F0055">null</span></u></strong>);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; dialog.addContentView(layout, <strong><span style="color:#7F0055">new</span></strong>LayoutParams(</span><span style="font-size:14px">LayoutParams.</span><span style="font-size:14px"><em><span style="color:#0000C0">FILL_PARENT</span></em></span><span style="font-size:14px">,LayoutParams.</span><span style="font-size:14px"><em><span style="color:#0000C0">WRAP_CONTENT</span></em></span><span style="font-size:14px">));</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ((TextView) layout.findViewById(R.id.<em><span style="color:#0000C0">title</span></em>)).setText(<span style="color:#0000C0">title</span>);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">if</span></strong> (<span style="color:#0000C0">positiveButtonText</span> !=<strong><span style="color:#7F0055">null</span></strong>) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ((Button) layout.findViewById(R.id.<em><span style="color:#0000C0">positiveButton</span></em>))</span><span style="font-size:14px">&nbsp;.setText(</span><span style="font-size:14px; color:rgb(0,0,192)">positiveButtonText</span><span style="font-size:14px">);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">if</span></strong> (<span style="color:#0000C0">positiveButtonClickListener</span> !=<strong><span style="color:#7F0055">null</span></strong>) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ((Button)layout.findViewById(R.id.<em><span style="color:#0000C0">positiveButton</span></em>))</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; .setOnClickListener(<strong><span style="color:#7F0055">new &nbsp;</span></strong>View.OnClickListener() {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span><span style="color:#7F0055">void &nbsp;</span></strong>onClick(View v) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#0000C0">
positiveButtonClickListener</span>.onClick(dialog,</span><span style="font-size:14px">DialogInterface.</span><span style="font-size:14px"><em><span style="color:#0000C0">BUTTON_POSITIVE</span></em></span><span style="font-size:14px">);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; });</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; } <strong><span style="color:#7F0055">else</span></strong> {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; layout.findViewById(R.id.<em><span style="color:#0000C0">positiveButton</span></em>).setVisibility(</span><span style="font-size:14px">View.</span><span style="font-size:14px"><em><span style="color:#0000C0">GONE</span></em></span><span style="font-size:14px">);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">if</span></strong> (<span style="color:#0000C0">negativeButtonText</span> !=<strong><span style="color:#7F0055">null</span></strong>) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ((Button) layout.findViewById(R.id.<em><span style="color:#0000C0">negativeButton</span></em>))</span><span style="font-size:14px">&nbsp;.setText(</span><span style="font-size:14px; color:rgb(0,0,192)">negativeButtonText</span><span style="font-size:14px">);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">if</span></strong> (<span style="color:#0000C0">negativeButtonClickListener</span> !=<strong><span style="color:#7F0055">null</span></strong>) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ((Button)layout.findViewById(R.id.<em><span style="color:#0000C0">negativeButton</span></em>))</span><span style="font-size:14px">.setOnClickListener(</span><span style="font-size:14px"><strong><span style="color:#7F0055">new
 &nbsp;</span></strong></span><span style="font-size:14px">View.OnClickListener() {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span><span style="color:#7F0055">void&nbsp;</span></strong>onClick(View v) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#0000C0">
negativeButtonClickListener</span>.onClick(dialog,</span><span style="font-size:14px">DialogInterface.</span><span style="font-size:14px"><em><span style="color:#0000C0">BUTTON_NEGATIVE</span></em></span><span style="font-size:14px">);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; });</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; } <strong><span style="color:#7F0055">else</span></strong> {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; layout.findViewById(R.id.<em><span style="color:#0000C0">negativeButton</span></em>).setVisibility(</span><span style="font-size:14px">&nbsp;View.</span><span style="font-size:14px"><em><span style="color:#0000C0">GONE</span></em></span><span style="font-size:14px">);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">if</span></strong> (<span style="color:#0000C0">message</span> !=<strong><span style="color:#7F0055">null</span></strong>) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ((TextView)layout.findViewById(R.id.<em><span style="color:#0000C0">message</span></em>)).setText(<span style="color:#0000C0">message</span>);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; } <strong><span style="color:#7F0055">else</span><span style="color:#7F0055">if</span></strong> (<span style="color:#0000C0">contentView</span> !=<strong><span style="color:#7F0055">null</span></strong>) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ((LinearLayout)layout.findViewById(R.id.<em><span style="color:#0000C0">content</span></em>))</span><span style="font-size:14px">&nbsp;.removeAllViews();</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ((LinearLayout)layout.findViewById(R.id.<em><span style="color:#0000C0">content</span></em>)).addView(</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#0000C0">contentView</span>,<strong><span style="color:#7F0055">new</span></strong>LayoutParams(LayoutParams.<em><span style="color:#0000C0">FILL_PARENT</span></em>,</span><span style="font-size:14px">LayoutParams.</span><span style="font-size:14px"><em><span style="color:#0000C0">FILL_PARENT</span></em></span><span style="font-size:14px">));</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; dialog.setContentView(layout);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span></strong> dialog;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">}</span></p>
<span style="font-size:14px">自定义View的布局文件：</span>
<p><span style="font-size:14px"></span></p>
<p><span style="color:teal">&lt;</span><span style="color:#3F7F7F">FrameLayout</span><span style="color:#7F007F">xmlns:android</span>=<em><span style="color:#2A00FF">&quot;http://schemas.android.com/apk/res/android&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;fill_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;fill_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:clickable</span>=<em><span style="color:#2A00FF">&quot;true&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:orientation</span>=<em><span style="color:#2A00FF">&quot;vertical&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:padding</span>=<em><span style="color:#2A00FF">&quot;20.0dip&quot;</span></em><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp; <u><span style="color:teal">&lt;</span><span style="color:#3F7F7F">LinearLayout</span></u></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;fill_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_gravity</span>=<em><span style="color:#2A00FF">&quot;center&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:background</span>=<em><span style="color:#2A00FF">&quot;#FA90BC&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:orientation</span>=<em><span style="color:#2A00FF">&quot;vertical&quot;</span></em><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">TextView</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/title&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">style</span>=<em><span style="color:#2A00FF">&quot;@style/text_18_ffffff&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;fill_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;40.0dip&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:gravity</span>=<em><span style="color:#2A00FF">&quot;center&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <u><span style="color:#7F007F">android:text</span>=<em><span style="color:#2A00FF">&quot;</span></em></u><em><u><span style="color:#2A00FF">提示</span><span style="color:#2A00FF">&quot;</span></u></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:visibility</span>=<em><span style="color:#2A00FF">&quot;visible&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">LinearLayout</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;fill_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:background</span>=<em><span style="color:#2A00FF">&quot;#ffffff&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:gravity</span>=<em><span style="color:#2A00FF">&quot;center&quot;</span></em><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">TextView</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/message&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">style</span>=<em><span style="color:#2A00FF">&quot;@style/text_16_666666&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;fill_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:gravity</span>=<em><span style="color:#2A00FF">&quot;left|center&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:lineSpacingMultiplier</span>=<em><span style="color:#2A00FF">&quot;1.5&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:minHeight</span>=<em><span style="color:#2A00FF">&quot;65.0dip&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:paddingBottom</span>=<em><span style="color:#2A00FF">&quot;15.0dip&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:paddingLeft</span>=<em><span style="color:#2A00FF">&quot;20.0dip&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:paddingRight</span>=<em><span style="color:#2A00FF">&quot;20.0dip&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:paddingTop</span>=<em><span style="color:#2A00FF">&quot;15.0dip&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;/</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">View</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;fill_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;1.0px&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:background</span>=<em><span style="color:#2A00FF">&quot;#ffd0d0d0&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">LinearLayout</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;fill_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;60.0dip&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_gravity</span>=<em><span style="color:#2A00FF">&quot;bottom&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:background</span>=<em><span style="color:#2A00FF">&quot;@drawable/dialog_bottom_bg&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:gravity</span>=<em><span style="color:#2A00FF">&quot;center&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:orientation</span>=<em><span style="color:#2A00FF">&quot;horizontal&quot;</span></em><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">Button</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/positiveButton&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">style</span>=<em><span style="color:#2A00FF">&quot;@style/text_15_ffffff_sdw&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;114.0dip&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;40.0dip&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:background</span>=<em><span style="color:#2A00FF">&quot;#FA90BC&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:gravity</span>=<em><span style="color:#2A00FF">&quot;center&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:text</span>=<em><span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">确定</span><span style="color:#2A00FF">&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">Button</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/negativeButton&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">style</span>=<em><span style="color:#2A00FF">&quot;@style/text_15_666666_sdw&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;114.0dip&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;40.0dip&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginLeft</span>=<em><span style="color:#2A00FF">&quot;20.0dip&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:background</span>=<em><span style="color:#2A00FF">&quot;#ffffff&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:gravity</span>=<em><span style="color:#2A00FF">&quot;center&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#7F007F">android:te</span></u><span style="color:#7F007F">xt</span>=<em><span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">取消</span><span style="color:#2A00FF">&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;/</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:teal">&gt;</span></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;/</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:teal">&gt;</span></p>
<p>&nbsp;</p>
<p><span style="color:teal">&lt;/</span><span style="color:#3F7F7F">FrameLayout</span><span style="color:teal">&gt;</span></p>
<br>
<p><span style="font-family:microsoft yahei; font-size:14px; color:#3366ff">MainActivity.Java</span></p>
<p></p>
<p><span style="font-size:14px"><strong><span style="color:#7F0055">public</span><span style="color:#7F0055">class &nbsp;</span></strong>MainActivity
<strong><span style="color:#7F0055">extends</span></strong> Activity {</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp; <span style="color:#646464">@Override</span></span></p>
<p><span style="font-size:14px">&nbsp;&nbsp; <strong><span style="color:#7F0055">protected</span><span style="color:#7F0055">void</span></strong>onCreate(Bundle savedInstanceState) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">super</span></strong>.onCreate(savedInstanceState);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;<span style="white-space:pre"> </span>&nbsp; setContentView(R.layout.<em><span style="color:#0000C0">activity_main</span></em>);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span><span style="color:#7F0055">void &nbsp;</span></strong>showAlertDialog(View view) {</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; DialogBox.Builder builder = <strong><span style="color:#7F0055">new&nbsp;</span></strong>DialogBox.Builder(<strong><span style="color:#7F0055">this</span></strong>);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; builder.setMessage(<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">删除该商品？</span><span style="color:#2A00FF">&quot;</span>);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; builder.setTitle(<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">温馨提示</span><span style="color:#2A00FF">&quot;</span>);</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; builder.setPositiveButton(<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">确定</span><span style="color:#2A00FF">&quot;</span>,<strong><span style="color:#7F0055">new&nbsp;</span></strong>DialogInterface.OnClickListener()
 {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span><span style="color:#7F0055">void</span></strong>onClick(DialogInterface dialog,
<strong><span style="color:#7F0055">int</span></strong> which) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; dialog.dismiss();</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#3F7F5F">// </span>
<span style="color:#3F7F5F">你的操作事项</span></span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; });</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; builder.setNegativeButton(<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">取消</span><span style="color:#2A00FF">&quot;</span>,</span><span style="font-size:14px">&nbsp;</span><span style="font-size:14px"><strong><span style="color:#7F0055">new&nbsp;</span></strong></span><span style="font-size:14px">android.content.DialogInterface.OnClickListener()
 {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span><span style="color:#7F0055">void</span></strong>onClick(DialogInterface dialog,
<strong><span style="color:#7F0055">int</span></strong> which) {</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="white-space:pre">
</span>dialog.dismiss();</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; });</span></p>
<p><span style="font-size:14px">&nbsp;</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; builder.create().show();</span></p>
<p><span style="font-size:14px">&nbsp;&nbsp; }</span></p>
<p><span style="font-size:14px">}</span></p>
<span style="font-size:14px"></span>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-size:14px; font-family:Arial; line-height:26px">
<span style="font-family:Verdana,Arial,Helvetica,sans-serif; line-height:21px"><span style="font-family:Arial; line-height:35px"><span style="color:rgb(204,0,0); font-family:&quot;Microsoft Yahei&quot;; font-size:18px; line-height:28px; text-indent:32px">源码下载：</span><br>
</span></span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-size:14px; font-family:Arial; line-height:26px">
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a target="_blank" href="http://download.csdn.net/detail/dickyqie/9649758">&nbsp;<span style="color:#ff9900"><span style="line-height:35px">http://download.csdn.net/detail/dickyqie/9649758</span></span></a></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-size:14px; font-family:Arial; line-height:26px">
<a target="_blank" target="_blank" href="http://download.csdn.net/detail/dickyqie/9632648" style="color:rgb(255,153,0); text-decoration:none; line-height:35px; background-color:transparent"></a></p>
<br>
<p><span style="font-family:&quot;microsoft yahei&quot;; font-size:14px"><br>
</span></p>
<p><span style="font-size:14px"><br>
</span></p>
<p><span style="font-size:14px"><br>
</span></p>
<p><span style="font-size:14px"><br>
</span></p>
<p><span style="font-size:14px"><br>
</span></p>
<p><span style="font-size:14px"><br>
</span></p>
<p><span style="font-size:14px"><br>
</span></p>
   
</div>
