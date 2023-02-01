<?php
    require_once 'functions.php';
?>
<?php function voting_page_display($poll_id, $origin) {?>
    <?php $polls = json_read('polls.json') ?>
    
    <!-- <a href="vote_query.php?id=<?=$poll_id?>">vote!</a> -->
    <form action="vote_query.php?" method="POST" style="background-color: lightgrey;">
    <input type="hidden" name="id" value="<?=$poll_id?>">
    <input type="hidden" name="origin" value="<?=$origin?>">
        <?php foreach($polls as $poll): ?>
            <?php if($poll->id == $poll_id) : ?>
                <h4><?= 'id: ' . $poll->id . '  ' ?></h4> 
                <h4><?= 'Question: ' . $poll->question ?><h4> <br>
                Your Answer: <br>
                <?php if($poll->isMultiple == "False") :?>
                    <?php foreach($poll->options as $option ): ?>
                        <input type="radio" name="answer" value="<?=$option?>"> <?=$option?> <br> <br>
                    <?php endforeach ?>
                <?php endif ?>
                <?php if($poll->isMultiple == "True") :?>
                    <?= "(You can select multiple options )" ?>
                    <br> <br>
                    <?php foreach($poll->options as $option ): ?>
                        <input type="checkbox" name="answers[]" value="<?=$option?>"> <?=$option?> <br> <br>
                    <?php endforeach ?>
                <?php endif ?>
                <?= 'Date Created: ' . $poll->createdAt ?> <br> <br>
                <?= 'Date ended: ' . $poll->deadline?> <br><br>
                
                    <input type="submit" value="Sumbit Vote">
            <?php endif ?>
        <?php endforeach ?>
    </form>



<?php }  ?>


<?php function page_errors($errors){ ?>
<div style="color: red;">
    <?php if(count($errors ?? []) == 0) return ?>

    <?php $error_dict = json_read('errors.json') ?>
    <h2>Error!</h2>
    <ul>
        <?php foreach($errors as $error): ?>
            <li><?=$error_dict->$error?></li>
        <?php endforeach ?>
    </ul>
</div>
<?php } // end page_errors ?>
