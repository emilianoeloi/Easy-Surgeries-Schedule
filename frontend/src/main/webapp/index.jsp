<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="A layout example that shows off a responsive product landing page.">

    <title>Landing Page &ndash; Layout Examples &ndash; Pure</title>

    






<link rel="stylesheet" href="assets/css/pure-min.css">





<link rel="stylesheet" href="/combo/1.6.3?/css/layouts/marketing.css">




    
<script src="http://use.typekit.net/gis6vng.js"></script>
<script>
    try { Typekit.load(); } catch (e) {}
</script>


    
<script>
(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
})(window,document,'script','//www.google-analytics.com/analytics.js','ga');

ga('create', 'UA-41480445-1', 'purecss.io');
ga('send', 'pageview');
</script>


</head>
<body>






<div class="content">
    <div class="header">
        <div class="pure-menu pure-menu-open pure-menu-fixed pure-menu-horizontal">
            <a class="pure-menu-heading" href="">Your Site</a>

            <ul>
                <li class="pure-menu-selected"><a href="#">Home</a></li>
                <li><a href="#">Tour</a></li>
                <li><a href="#">API</a></li>
                <li><a href="#">Blog</a></li>
                <li><a href="#">About</a></li>
            </ul>
        </div>
    </div>

    <div class="splash">
        <div class="pure-g-r">
            <div class="pure-u-1-3">
                <div class="l-box splash-image">
                    <img src="http://placehold.it/500x350"
                         alt="Placeholder image for example.">
                </div>
            </div>

            <div class="pure-u-2-3">
                <div class="l-box splash-text">
                    <h1 class="splash-head">
                        Some big bold text.
                    </h1>

                    <h2 class="splash-subhead">
                        The HTML and CSS for this layout show how you can make a modern, responsive landing page for your next product. Browse through the source to see how we use menus and responsive grids to create this layout. Shrink your browser width and watch the layout transform and play nice with small screens.
                    </h2>

                    <p>
                        <a href="#" class="pure-button primary-button">Get Started</a>
                    </p>
                </div>
            </div>
        </div>
    </div>

    <div class="content">
        <div class="pure-g-r content-ribbon">
            <div class="pure-u-2-3">
                <div class="l-box">
                    <h4 class="content-subhead">Some small text</h4>

                    <h3>Lorem ipsum dolor sit amet.</h3>
                    <p>
                        Pellentesque hendrerit lobortis ornare. Fusce luctus imperdiet consequat. Nullam quis nunc quis ligula luctus vestibulum non quis libero. Suspendisse tristique nisl ut velit facilisis sit amet lobortis nulla pharetra.
                    </p>
                </div>
            </div>

            <div class="pure-u-1-3">
                <div class="l-box">
                    <img src="http://placehold.it/400x250"
                         alt="Placeholder image for example.">
                </div>
            </div>
        </div>

        <div class="pure-g-r content-ribbon">
            <div class="pure-u-1-3">
                <div class="l-box">
                    <img src="http://placehold.it/400x250"
                         alt="Placeholder image for example.">
                </div>
            </div>

            <div class="pure-u-2-3">
                <div class="l-box">
                    <h4 class="content-subhead">Some more small text</h4>

                    <h3>Etiam iaculis iaculis lobortis.</h3>
                    <p>
                        Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum. Morbi fermentum dui sit amet libero tincidunt rutrum. Nam sodales consequat metus sed accumsan.
                    </p>
                </div>
            </div>
        </div>

        <div class="pure-g-r">
            <div class="pure-u-1-4">
                <div class="l-box">
                    <h3>Subheading</h3>
                    <p>
                        Donec suscipit, risus vel venenatis ornare, nibh massa ultrices diam, a elementum metus felis sit amet eros. Phasellus pellentesque euismod massa sed pellentesque.
                    </p>
                </div>
            </div>

            <div class="pure-u-1-4">
                <div class="l-box">
                    <h3>Subheading</h3>
                    <p>
                        Donec suscipit, risus vel venenatis ornare, nibh massa ultrices diam, a elementum metus felis sit amet eros. Phasellus pellentesque euismod massa sed pellentesque.
                    </p>
                </div>
            </div>

            <div class="pure-u-1-4">
                <div class="l-box">
                    <h3>Subheading</h3>
                    <p>
                        Donec suscipit, risus vel venenatis ornare, nibh massa ultrices diam, a elementum metus felis sit amet eros. Phasellus pellentesque euismod massa sed pellentesque.
                    </p>
                </div>
            </div>

            <div class="pure-u-1-4">
                <div class="l-box">
                    <h3>Subheading</h3>
                    <p>
                        Donec suscipit, risus vel venenatis ornare, nibh massa ultrices diam, a elementum metus felis sit amet eros. Phasellus pellentesque euismod massa sed pellentesque.
                    </p>
                </div>
            </div>
        </div>

        <div class="l-box ribbon">
            <h2>Get started now.</h2>
            <a href="#" class="pure-button primary-button">Sign up</a>
        </div>
    </div>

    <div class="footer">
        View the source of this layout to learn more. Made with love by the YUI Team.
    </div>
</div>

<script src="http://yui.yahooapis.com/3.12.0/build/yui/yui-min.js"></script>
<script>
YUI().use('node-base', 'node-event-delegate', function (Y) {
    // This just makes sure that the href="#" attached to the <a> elements
    // don't scroll you back up the page.
    Y.one('body').delegate('click', function (e) {
        e.preventDefault();
    }, 'a[href="#"]');
});
</script>



</body>
</html>
